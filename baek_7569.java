import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
public class baek_7569 {
	static int[] dr = { 0, 1, -1, 0, 0, 0 };
	static int[] dc = { 1, 0, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int N, M, H;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[][][] arr = new int[H][N][M];
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						queue.add(new int[] { i, j, k, 0 });
						visit[i][j][k] = true;
					}
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int h = now[0];
			int n = now[1];
			int m = now[2];
			int cnt = now[3];
			answer = Math.max(answer, cnt);
			for (int i = 0; i < 6; i++) {
				int nn = n + dr[i];
				int nm = m + dc[i];
				int nh = h + dh[i];
				if (0 <= nn && nn < N && 0 <= nm && nm < M && 0 <= nh && nh < H && !visit[nh][nn][nm]
						&& arr[nh][nn][nm] == 0) {
					queue.add(new int[] { nh, nn, nm, cnt + 1 });
					visit[nh][nn][nm] = true;
					arr[nh][nn][nm] = 1;
				}
			}
		}
		if (check(arr)) {
			System.out.println(answer);
		} else
			System.out.println(-1);
	}

	static boolean check(int[][][] arr) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {

					if (arr[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
