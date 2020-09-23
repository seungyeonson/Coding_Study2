package _0922;
//RGB 거리 DP
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N][3];
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					dp[i][j] = RGB[i][j];
					continue;
				}

				dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3] + RGB[i][j],
						dp[i - 1][(j + 2) % 3] + RGB[i][j]);
			}
		}
		int answer = Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2]));
		System.out.println(answer);
	}
}
