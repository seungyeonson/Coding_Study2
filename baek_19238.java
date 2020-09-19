import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//택시
public class baek_19238 {
	static int N, M, G, map[][], customer[][], start[], end[], count, answer;
	static boolean visit[][][], flag;
	static PriorityQueue<Node> queue;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cnt;

		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			int temp = Integer.compare(this.cnt, o.cnt);
			if (temp == 0) {
				temp = Integer.compare(this.x, o.x);
				if (temp == 0) {
					temp = Integer.compare(this.y, o.y);
				}
			}
			return temp;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		start = new int[2];
		end = new int[2];
		customer = new int[M][4];
		visit = new boolean[N][N][M * 2];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		start[0] = Integer.parseInt(st.nextToken()) - 1;
		start[1] = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			customer[i][0] = Integer.parseInt(st.nextToken()) - 1;
			customer[i][1] = Integer.parseInt(st.nextToken()) - 1;
			customer[i][2] = Integer.parseInt(st.nextToken()) - 1;
			customer[i][3] = Integer.parseInt(st.nextToken()) - 1;
			map[customer[i][0]][customer[i][1]] = 2;
		}
		count = 0;
		answer = 0;
		for (int i = 0; i < M; i++) {
			queue = new PriorityQueue<>();
			queue.add(new Node(start[0], start[1], 0));
			flag = false;
			findCustom();
			if (!flag) {
				answer = -1;
				break;
			}
			queue = new PriorityQueue<>();
			queue.add(new Node(start[0], start[1], 0));
			flag = false;
			findDest();
			if (!flag) {
				answer = -1;
				break;
			}
			answer = G;
		}
		System.out.println(answer);

	}

	static void findCustom() {
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			if (map[x][y] == 2) {
				for (int i = 0; i < M; i++) {
					if (x == customer[i][0] && y == customer[i][1]) {
						start[0] = x;
						start[1] = y;
						end[0] = customer[i][2];
						end[1] = customer[i][3];
						count++;
						flag = true;
						G = G - cnt;
						map[x][y] = 0;
						break;
					}
				}
				return;
			}
			if (cnt >= G) {
				flag = false;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[nx][ny][count] && map[nx][ny] != 1) {
					queue.add(new Node(nx, ny, cnt + 1));
					visit[nx][ny][count] = true;
				}
			}
		}
	}

	static void findDest() {
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			if (x == end[0] && y == end[1]) {

				start[0] = x;
				start[1] = y;
				flag = true;
				G = G + cnt;
				count++;
				return;
			}
			if (cnt >= G) {
				flag = false;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visit[nx][ny][count] && map[nx][ny] != 1) {
					queue.add(new Node(nx, ny, cnt + 1));
					visit[nx][ny][count] = true;
				}
			}
		}
	}

}
