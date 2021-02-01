import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 바이러스 2606
// 풀때는 연결리스트를 만든다음 연결되어 있으면 큐에 넣어서 자식들을 탐색하자.
public class baek_2606 {
	static int N, M, arr[][];
	static boolean visited[];
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1;
			arr[B][A] = 1;
		}
		System.out.println(virus(1));

	}

	static int virus(int start) {
		visited[start] = true;
		for (int i = 1; i < N + 1; i++) {
			if (arr[1][i] == 1) {
				queue.add(i);
			}
		}
		int count = 0;
		while (!queue.isEmpty()) {
			int child = queue.poll();
			if (!visited[child]) {
				visited[child] = true;
				count++;
				for (int i = 1; i < N + 1; i++) {
					if (arr[child][i] == 1 && !visited[i])
						queue.add(i);
				}
			}
		}

		return count;
	}
}
