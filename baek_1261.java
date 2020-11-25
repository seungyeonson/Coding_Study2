import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek_1261 {
	static PriorityQueue<Node> queue;
	static int arr[][], N, M, answer;
	static boolean[][] visit;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", w=" + w + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		queue = new PriorityQueue<>();
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}
		queue.add(new Node(0, 0, 0));
		visit[0][0] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				answer = now.w;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visit[nx][ny]) {
					queue.add(new Node(nx, ny, now.w + arr[nx][ny]));
					visit[nx][ny] = true;
				}
			}
		}
		System.out.println(answer);
	}
}
