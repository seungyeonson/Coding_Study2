import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//달이 차오른다, 가자.
public class baek_1194 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[N][M][1 << 6];
		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '0') {
					queue.add(new int[] { i, j, 0, 0 });
					visit[i][j][0] = true;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			//System.out.println(now[0]+" "+now[1]+" "+now[2]+" "+now[3]);
			if (arr[now[0]][now[1]] == '1') {
				System.out.println(now[2]);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int key = now[3];
				int dx = now[0] + dr[i];
				int dy = now[1] + dc[i];
				
				if (dx < 0 || dx >= N || dy < 0 || dy >= M)
					continue;
				if (arr[dx][dy] == '#')
					continue;
				if(visit[dx][dy][key])
					continue;
				if (arr[dx][dy] >= 'A' && arr[dx][dy] <= 'F') {
					if ((key & (1 << (arr[dx][dy] - 'A') ) ) == 0) {
						//System.out.println(key);
						//System.out.println(key & (1 << (arr[dx][dy] - 'A') ));
						continue;
					}
					//System.out.println(key);
					queue.add(new int[] { dx, dy, now[2] + 1, key });
					visit[dx][dy][key] = true;

				}
				if (arr[dx][dy] >= 'a' && arr[dx][dy] <= 'f'){
					//System.out.println(key);
					key |= (1 << (arr[dx][dy] - 'a'));
					//System.out.println(key);
					queue.add(new int[] { dx, dy, now[2] + 1, key});
					visit[dx][dy][key] = true;
				}
				if (arr[dx][dy] == '.' | arr[dx][dy] == '1' | arr[dx][dy]=='0') {
					queue.add(new int[] { dx, dy, now[2] + 1, key });
					visit[dx][dy][key] = true;
				}
				
			}

		}
		System.out.println(-1);

	}
}
