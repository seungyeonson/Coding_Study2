import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17276 {
	static int arr[][], N, D, temp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			temp = new int[8][N];
			for (int i = 0; i < N; i++) {

				temp[0][i] = arr[i][i];
				temp[1][i] = arr[i][N / 2];
				temp[2][i] = arr[i][N - 1 - i];
				temp[3][i] = arr[N / 2][N - 1 - i];
				temp[4][i] = arr[N - 1 - i][N - 1 - i];
				temp[5][i] = arr[N - 1 - i][N / 2];
				temp[6][i] = arr[N - 1 - i][i];
				temp[7][i] = arr[N / 2][i];
			}
//			for (int i = 0; i < 8; i++) {
//				System.out.println(Arrays.toString(temp[i]));
//			}
			int d = ((D + 360) % 360) / 45;

			for (int i = 0; i < N; i++) {
				arr[i][i] = temp[(8 - d) % 8][i];
				arr[i][N / 2] = temp[(8 - d + 1) % 8][i];
				arr[i][N - 1 - i] = temp[(8 - d + 2) % 8][i];
				arr[N / 2][N - 1 - i] = temp[(8 - d + 3) % 8][i];

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
