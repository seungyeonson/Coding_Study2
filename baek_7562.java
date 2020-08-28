import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7562 {
	static int[] dr = { -2, -1, -2, -1, 1, 1, 2, 2 };
	static int[] dc = { 1, 2, -1, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean[][] visit = new boolean[N][N];
			int[] from = new int[2];
			int[] to = new int[2];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 2; i++) {
				from[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 2; i++) {
				to[i] = Integer.parseInt(st.nextToken());
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { from[0], from[1], 0 });
			visit[from[0]][from[1]] = true;
			int answer = 0;
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				if (now[0] == to[0] && now[1] == to[1]) {
					answer = now[2];
					break;
				}
				for (int i = 0; i < 8; i++) {
					int nx = now[0] + dr[i];
					int ny = now[1] + dc[i];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[nx][ny]) {
						queue.add(new int[] { nx, ny, now[2] + 1 });
						visit[nx][ny] = true;
					}
				}
			}
			System.out.println(answer);
		}
	}
}
