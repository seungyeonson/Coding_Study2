import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 11724 연결 요소의 개수
//처음에 인접행렬로 접근했는데 시간복잡도로 인해 인접리스트로 접근하자.
public class baek_11724_인접행렬 {
	static int N, M, arr[][], answer;
	static boolean[] visited;
	static Queue<Integer> queue;
	static Node[] nodes;
	static class Node {
		int level;
		ArrayList<Integer> child;

		Node() {
			child = new ArrayList<>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Node[] arr = new Node[N+1];
		for(int i=0;i<N+1;i++) {
			arr[i] = new Node();
		}
		visited = new boolean[N+1];
		queue = new LinkedList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].child.add(B);
			arr[B].child.add(A);
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				answer++;
				if(arr[i].child.isEmpty()) {
					continue;
				}
				queue.add(i);
				visited[i] = true;
				while(!queue.isEmpty()) {
					int now = queue.poll();
					
					for(int j : arr[now].child) {
						if(!visited[j]) {
							queue.add(j);
							visited[j] = true;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
