import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_광주_2반_송승연 {
	public static void main(String[] args) throws IOException {
		// 자바 Input 처리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 문제에서 주어진 입력을 변수에 저장
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int H1 = Integer.parseInt(st.nextToken());
		int H2 = Integer.parseInt(st.nextToken());

		// 초기 정답값을 -1로 설정하여 만나지 못했을 때 -1을 출력하도록 한다.
		int answer = -1;
		
		//서로 찍은 위치를 표현하기 위해 크기가 10000인 배열을 선언
		int[] distance = new int[10000];
		
		//10000미터 이상 진행한 경우 둘은 만날 수 없다고 판단한다.
		while ( H1<10000 && H2 <10000) {
			
			//현재 두사람의 위치에 1씩 더해준다.
			distance[H1]++;
			distance[H2]++;
			
			//더해준 위치가 만약 2가 된다면 만난것이다.
			if(distance[H1]==2 || distance[H2]==2) {
				answer = distance[H1]==2 ? H1 : H2;
				break;
			}
			
			//각각 뜀뛰기 보폭만큼 더해준다.
			H1 += X;
			H2 += Y;
		}
		System.out.println(answer);
	}
}
