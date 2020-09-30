import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17406 {
	static int N, M, K, A[][], B[][], turn[][], answer;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] select = new int[K];
		for (int i = 0; i < K; i++)
			select[i] = i;
		A = new int[N][M];
		B = new int[N][M];
		turn = new int[K][3];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
			turn[i][2] = Integer.parseInt(st.nextToken());
		}
		permutation(select, 0, K - 1);
		System.out.println(answer);
	}

	static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	static void permutation(int[] str, int l, int r) {
		if (l == r) {
			for (int i = 0; i < N; i++) {
				B[i] = A[i].clone();
			}
			for (int i = 0; i < K; i++) {
				turn(turn[str[i]][0] - 1, turn[str[i]][1] - 1, turn[str[i]][2]);

			}
			answer = Math.min(answer, calA(B, answer));
		} else {
			for (int i = l; i <= r; i++) {
				swap(str, l, i);
				permutation(str, l + 1, r);
				swap(str, l, i); // backtrack
			}
		}
	}

	private static int calA(int[][] arr, int min) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];
				if (sum >= min) {
					sum = min;
					break;
				}
			}
			min = Math.min(sum, min);
		}
		return min;
	}

	static void turn(int r, int c, int s) {
		for (int i = 1; i <= s; i++) {
			int[][] temp = { { r - i, c - i, B[r - i][c - i] }, { r - i, c + i, B[r - i][c + i] },
					{ r + i, c + i, B[r + i][c + i] }, { r + i, c - i, B[r + i][c - i] } };
			for (int j = 0; j < 4; j++) {
				int v = temp[j][2];
				int x = temp[j][0];
				int y = temp[j][1];

				for (int k = 2 * i; k >= 1; k--) {
					B[x + k * dr[j]][y + k * dc[j]] = B[x + (k - 1) * dr[j]][y + (k - 1) * dc[j]];

					if (k == 1) {
						B[x + k * dr[j]][y + k * dc[j]] = v;
					}
				}

			}
		}
	}
}
