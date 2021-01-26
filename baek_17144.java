import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미세먼지 안녕! 17144
public class baek_17144 {
	static int R, C, T, arr[][];
	static int[] dr = { 0, -1, 0, 1, 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0, 1, 0, -1, 0 };
	static Queue<int[]> queue;

	static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != 0 && arr[i][j] != -1) {
					queue.add(new int[] { i, j, arr[i][j] });
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int n = now[2];
			int count = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny]==-1) {
					continue;
				}
				count++;
				arr[nx][ny] = arr[nx][ny] + n / 5;
			}
			arr[x][y] = arr[x][y] - count * (n / 5);
		}
	}

	static void blow() {
		for (int i = 0; i < R; i++) {
			if (arr[i][0] == -1) {
				turn(i, 0);
				turn(i + 1, 1);
				break;
			}
		}
	}

	static void turn(int row, int d) {
		int dx = row;
		int dy = 0;
		int now = 0;
		int temp = 0;
		for (int i = d * 4 + 0; i < d * 4 + 4; i++) {
			while (true) {
				dx = dx + dr[i];
				dy = dy + dc[i];

				if (dx < 0 || dx >= R || dy < 0 || dy >= C) {
					dx = dx - dr[i];
					dy = dy - dc[i];
					break;
				}
				if (arr[dx][dy] == -1) {
					break;
				}
				temp = arr[dx][dy];

				arr[dx][dy] = now;
				now = temp;

			}
		}
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static int sum() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == -1) {
					continue;
				}
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		print();
		for (int i = 0; i < T; i++) {
			queue = new LinkedList<>();
			spread();
			blow();
//			print();
		}
		System.out.println(sum());
	}
}
