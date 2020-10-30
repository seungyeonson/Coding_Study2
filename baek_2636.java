import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2636 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int answer;
	static int w, h, arr[][];
	static Queue<int[]> queue;
	static Queue<int[]> queue2;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[w][h];
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < h; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		queue = new LinkedList<>();
		queue2 = new LinkedList<>();
		visited = new boolean[w][h];
		queue.add(new int[] { 0, 0 });
		arr[0][0] = -1;
		visited[0][0] = true;
		int cnt = 0;
		while (findOne()) {
			cnt++;
			fillminus();
			findEdge();
			while (!queue2.isEmpty()) {
				int[] now = queue2.poll();
				arr[now[0]][now[1]] = 0;
				if (queue.isEmpty()) {
					queue.add(new int[] { now[0], now[1] });
					arr[now[0]][now[1]] = -1;
					visited[now[0]][now[1]] = true;
				}
			}
			System.out.println(cnt);
			System.out.println(answer);
		}
	}

	static void fillminus() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dr[i];
				int ny = now[1] + dc[i];
				if (nx >= 0 && nx < w && ny >= 0 && ny < h && arr[nx][ny] == 0 && !visited[nx][ny]) {
				
					queue.add(new int[] { nx, ny });
					visited[nx][ny] = true;
					arr[nx][ny] = -1;
				}
			}
		}
	}

	static void findEdge() {
		answer=0;
		for (int i = 1; i < w - 1; i++) {
			for (int j = 1; j < h - 1; j++) {
				if (arr[i][j] == 1) {
					answer++;
					boolean check = false;
					for (int k = 0; k < 4; k++) {
						if (arr[i + dr[k]][j + dc[k]] == -1) {
							check = true;
							break;
						}
					}
					if (check) {
						queue2.add(new int[] { i, j });
					}

				}

			}
		}
	}
	static boolean findOne() {
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(arr[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}
}
