import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1012 {
	static int[][] map;
	static int[][] lettuce, visit;
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new int[N][M];
			lettuce = new int[K][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				lettuce[i][1] = Integer.parseInt(st.nextToken());
				lettuce[i][0] = Integer.parseInt(st.nextToken());
				map[lettuce[i][0]][lettuce[i][1]]++;
			}
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && visit[i][j] == 0) {
						queue = new LinkedList<>();
						queue.add(new int[] { i, j });
						visit[i][j]++;
						answer++;
						while (!queue.isEmpty()) {
							int temp[] = queue.poll();
							for (int k = 0; k < 4; k++) {
								int dx = temp[0] + dr[k];
								int dy = temp[1] + dc[k];
								if (0 <= dx && dx < N && 0 <= dy && dy < M && visit[dx][dy] == 0 && map[dx][dy] != 0) {
									queue.add(new int[] { dx, dy });
									visit[dx][dy]++;
								}
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

}
