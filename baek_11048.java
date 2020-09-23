package _0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//이동하기(DP)
public class baek_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = map[i][j];
					continue;
				}
				int max = 0;
				if (i - 1 >= 0 && j - 1 >= 0) {
					max = Math.max(dp[i - 1][j - 1] + map[i][j], max);
				}
				if (i - 1 >= 0) {
					max = Math.max(dp[i - 1][j] + map[i][j], max);
				}
				if (j - 1 >= 0) {
					max = Math.max(dp[i][j-1] + map[i][j], max);
				}
				dp[i][j] = Math.max(dp[i][j], max);
			}
		}
		System.out.println(dp[N - 1][M - 1]);

	}
}
