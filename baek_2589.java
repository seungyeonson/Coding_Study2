import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2589 {
	static char[][] map;
	static int N, M, answer, count;
	static boolean[][] visited;
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		queue = new LinkedList<>();
		answer =0;
		for (int i = 0; i < N; i++) {
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					count = 0;
					bfs(i, j);
					if (answer < count) {   
						answer = count;
					}
				}
			}
		}
		System.out.println(answer);

	}

	private static void bfs(int i, int j) {
		visited = new boolean[N][M];
		queue.add(new int[] { i, j, 0 });
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int cnt = now[2];
			count = cnt;
			for (int d = 0; d < 4; d++) {
				int nx = x + dr[d];
				int ny = y + dc[d];
				if(0>nx || nx>=N || 0>ny || ny >=M) continue;
				if(visited[nx][ny]||map[nx][ny]=='W') continue;
				queue.add(new int[] {nx, ny, cnt+1});
				visited[nx][ny] = true;
			}
		}

	}
}
