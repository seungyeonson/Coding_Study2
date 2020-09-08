import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_17070 {
	static int N, arr[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		answer = 0;
		dfs(0, 1, 2);

		System.out.println(answer);

	}// end main

	static void dfs(int x, int y, int status) {
		if (x == N - 1 && y == N - 1) {
			answer++;
			return;
		}

		// 현재 상태가 기울 또는 누워있으면 누워 가능
		// 현재 상태가 서있 기울이면 서가능
		// 현재 상태가 어떤 상태라도 기울 가능
		if (status == 0 || status == 1) {
			if (x + 1 < N && arr[x + 1][y] == 0)
				dfs(x + 1, y, 0);
		}
		if (status == 1 || status == 2) {
			if (y + 1 < N && arr[x][y + 1] == 0)
				dfs(x, y + 1, 2);
		}
		if (x + 1 < N && y + 1 < N && arr[x + 1][y] != 1 && arr[x][y + 1] != 1 && arr[x + 1][y + 1] != 1) {
			dfs(x + 1, y + 1, 1);
		}
	}

}
