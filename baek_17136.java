import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17136 {
	static int N = 10, answer = Integer.MAX_VALUE;
	static int map[][], paper[], oneCnt;
	static ArrayList<int[]> One;
	static boolean visit[][], flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		One = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					oneCnt++;
					//1의 좌표를 담아놓을 저장공간
					One.add(new int[] { i, j });
				}
			}
		} // end input
		visit = new boolean[N][N];
		paper = new int[N];
		flag = false;
		findOne(0, 0);
		//1이 하나도 없다면 정답은 0
		if (One.size() == 0) {
			System.out.println(0);
		//정답을 찾지 못했으면 -1
		} else if (!flag) {
			System.out.println(-1);
		} else if(flag)
			System.out.println(answer);
	}// end main
	//색종이를 붙이는 재귀함수
	static void findOne(int idx, int cnt) {
		//idx가 1의 개수만큼 돌면 끝난거다.
		if (idx == oneCnt) {
			flag = true;
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt > answer) {
			return;
		}
		//현재 1의 좌표를 뺸다.
		int nx = One.get(idx)[0];
		int ny = One.get(idx)[1];
		//System.out.println(nx+" "+ny);
		//1이 색칠되어 있지 않은경우
		if (!visit[nx][ny]) {
			//색종이는 5개이고 큰거부터 붙이고 싶어~~
			for (int k = 5; k > 0; k--) {
				//색종이를 붙일수있는지 체크
				if (check(nx, ny, k)) {
					//붙일 수 있다면
					// 색종이크기 k 를 붙이자
					color(nx, ny, k, true);
					//다음 1을 찾으러 가자
					findOne(idx + 1, cnt + 1);
					// 색종이 크기 k를 떼자
					color(nx, ny, k, false);
				}
			}
			//색종이를 하나도 못붙였거나 for이 끝난경우는 return
			return;
		//1이 이미 색칠되어있는 경우
		} else {
			findOne(idx + 1, cnt);
		}
	}

	static boolean check(int x, int y, int c) {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				if (x + i >= N || y + j >= N || map[x + i][y + j] != 1 || visit[x + i][y + j] || paper[c - 1] >= 5)
					return false;
			}
		}
		return true;
	}

	static void color(int x, int y, int c, boolean check) {
		if (check)
			paper[c - 1]++;
		else
			paper[c - 1]--;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				visit[x + i][y + j] = check;
			}
		}
	}
}
