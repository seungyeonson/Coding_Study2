import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1600_BFS {
	static int K, W, H;
	static int[][] arr;
	static boolean[][][] visit;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };
	static int[] rr = { 1, 2, -1, -2, 1, 2, -1, -2 };
	static int[] cc = { 2, 1, -2, -1, -2, -1, 2, 1 };
	static int answer;
	static Queue<int[]> queue;
	static boolean flag;

	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if (temp[0] == W - 1 && temp[1] == H - 1) {
				flag = true;
				if (answer > temp[3]) {
					answer = temp[3];
				}
			}
			if (temp[2] < K) {
				for (int i = 0; i < 8; i++) {
					int dx = temp[0] + rr[i];
					int dy = temp[1] + cc[i];
					if (0 <= dx && dx < W && 0 <= dy && dy < H && !visit[dx][dy][temp[2] + 1] && arr[dx][dy] != 1) {
						visit[dx][dy][temp[2] + 1] = true;
						queue.add(new int[] { dx, dy, temp[2] + 1, temp[3] + 1 });
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				int dx = temp[0] + dr[i];
				int dy = temp[1] + dc[i];
				if (0 <= dx && dx < W && 0 <= dy && dy < H && !visit[dx][dy][temp[2]] && arr[dx][dy] != 1) {
					visit[dx][dy][temp[2]] = true;
					queue.add(new int[] { dx, dy, temp[2], temp[3] + 1 });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W][H];
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < H; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = W * H;
		queue = new LinkedList<>();
		visit = new boolean[W][H][K + 1];
		visit[0][0][0] = true;
		queue.add(new int[] { 0, 0, 0, 0 });
		bfs();
		if (flag)
			System.out.println(answer);
		else {
			System.out.println(-1);
		}
	}
}
