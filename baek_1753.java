import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1753 {
	static class Node implements Comparable<Node> {
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public String toString() {
			return v + "" + w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		final int INFINITY = Integer.MAX_VALUE;
		int start = Integer.parseInt(in.readLine().trim()) - 1;
		boolean[] visit = new boolean[V];
		int[] distance = new int[V];
		List<Node>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Node(v, w));
		}
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		for (int i = 0; i < V; i++) {
			int min = INFINITY;
			int current = -1;
			for (int j = 0; j < V; j++) {
				if (!visit[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}

			}
			if (current == -1) {
				break;
			}

			for (Node n : adj[current])
				if (!visit[n.v] && distance[current] +n.w < distance[n.v] ) {
					distance[n.v] = distance[current] + n.w;
				}
			visit[current] = true;
		}
		for(int i=0;i<V;i++) {
			if(distance[i]==INFINITY)
				System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
}
