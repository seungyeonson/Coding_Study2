import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_16927 {
	static int B[][], N, M, K;
	static int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		turn(0, 0, N - 1, M - 1, Math.min(N, M) / 2, K);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(B[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void turn(int r, int c, int N, int M, int R, int K) {

		if (R > 0) {
			int num = K %((N-r)*2+(M-c)*2);
			for (int k = 0; k < num; k++) {
				int dir = 0;
				
				int nowv = B[r][c];
				int nowr = r;
				int nowc = c;
				int newv;
				int newR;
				int newC;
				while (dir < 4) {
					newR = nowr + direction[dir][0];
					newC = nowc + direction[dir][1];
					if (newR < r || newR > N || newC < c || newC > M) {
						dir++;
					} else {
						newv = B[newR][newC];
						B[newR][newC] = nowv;
						nowv = newv;
						nowr = newR;
						nowc = newC;
					}
				}
			}
				turn(r + 1, c + 1, N - 1, M - 1, R - 1, K);
			
		}
	}

}