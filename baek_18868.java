import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_광주_2반_송승연 {
	static int M, N, answer;
	static int[][] classes;
	static int[] chclass, chstud;
	static boolean flag;
	//학급을 2개 고르는 조합
	static void combination(int idx, int idx_s) {
		//학급의 고른 개수가 2이면 학생을 고르는 조합으로 보내기 
		if(idx_s==2) {
			flag = true;
			combination2(0,0, chclass[0], chclass[1]);
			if(flag) answer++;
			return;
		}
		//만약 idx가 M이 되면 리턴
		if(idx==M) {
			return;
		}
		//먼저 idx_s에 idx를 저장하고 combination에 이를 선택하는 경우 선택하지 않는 경우로 나누어 탐색
		chclass[idx_s] = idx;
		combination(idx+1,idx_s+1);
		combination(idx+1,idx_s);
	}
	//학생을 두개 고르는 조합
	static void combination2(int idx, int idx_s, int A, int B) {
		//학생의 고른 개수가 2이면 학생끼리의 점수를 비교한다.
		if(idx_s==2) {
			//한 학급내에서 모두 조건을 만족하도록 한번이라도 false가 나오면 종료한다.
			if(!check(chstud, A, B)) flag = false;
			return;
		}
		//한 학급내에서 모두 조건을 만족하도록 한번이라도 false가 나오면 종료한다.
		if(idx==N || ! flag) {
			return;
		}
		//먼저 idx_s에 idx를 저장하고 combination2에 이를 선택하는 경우 선택하지 않는 경우로 나누어 탐색
		chstud[idx_s] = idx;
		combination2(idx+1,idx_s+1, A, B);
		combination2(idx+1,idx_s, A, B);
	}
	//조건에 맞는지 체크하는 함수
	static boolean check(int[] chstud, int A, int B) {
		//조건에 맞으면 true를 리턴
		if(classes[A][chstud[0]] <classes[A][chstud[1]] && classes[B][chstud[0]] <classes[B][chstud[1]])
			return true;
		//조건에 맞으면 true를 리턴
		else if(classes[A][chstud[0]] > classes[A][chstud[1]] && classes[B][chstud[0]] > classes[B][chstud[1]]) 
			return true;
		//조건에 맞으면 true를 리턴
		else if(classes[A][chstud[0]] == classes[A][chstud[1]] && classes[B][chstud[0]] == classes[B][chstud[1]])
			return true;
		////해당되지 않으면 false를 리턴
		return false;
	}
	public static void main(String[] args) throws IOException {
		// 자바 Input 처리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		//M은 학급 수 N은 학생 수
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		//정답값 0으로 초기화 정답은 해당하는 조건에 만족하는 학급쌍의 수
		answer = 0;
		// input을 담을 배열 학급과 학생 점수의 배열
		classes = new int[M][N];
		//탐색하면서 비교할 학급을 담는 배열
		chclass = new int[2];
		//탐색하면서 비교할 학생점수를 고르는 배열
		chstud = new int[2];
		
		//입력값 저장
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				classes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//탐색 시작
		combination(0,0);
		System.out.println(answer);
	}
}
