import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 11724 연결 요소의 개수
public class baek_11724_연결리스트 {
	static int N, M, arr[][], answer;
	static boolean[] visited;
	static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		queue = new LinkedList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1;
			arr[B][A] = 1;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				answer++;
				queue.add(i);
				visited[i] = true;
				while(!queue.isEmpty()) {
					int now = queue.poll();
					
					for(int j=1;j<=N;j++) {
						if(arr[now][j]==1 && !visited[j]) {
                            visited[j] = true;
							queue.add(j);
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
