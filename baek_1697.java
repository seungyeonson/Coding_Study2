import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
def bfs(arr, start, end):
    while queue:
        current_node = queue.pop(0)

        if current_node==K:
            return arr[K]

        for j in [current_node+1,current_node-1,current_node*2]:
            if 0<=j<=Max and arr[j]==0:
                arr[j] = arr[current_node]+1
                queue.append(j)
        
    return arr[K]
    
N, K = map(int,input().split())
Max=100000
arr=[0]*(Max+1)
queue=[N]
print(bfs(arr,N, K))
*/
public class baek_1697 {
	static int max = 100000;
	static int[] arr = new int[max+1];
	static Queue<Integer> queue;
	static int N,K;
	static int bfs(int x, int y) {
		while(!queue.isEmpty()) {
			int current_node = queue.poll();
			
			if (current_node ==K) {
				return arr[K];
			}
			for(int i=0;i<3;i++) {
				
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		queue.add(N);
	}

}
