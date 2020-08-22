import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_5014 {
	static int F, S, G, U, D;
	static int[] arr;
	static int[] dr;
	static Queue<Integer> queue;
	static boolean flag;

	static void bfs() {
		while (!queue.isEmpty()) {
			int floor = queue.poll();
			if (floor == G) {
				flag = true;
				break;
			}
			for (int i = 0; i < 2; i++) {
				int temp = floor + dr[i];
				if (0 < temp && temp <= F && arr[temp] == 0) {
					arr[temp] = arr[floor] + 1;
					queue.add(temp);
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[F + 1];
		dr = new int[2];
		dr[0] = U;
		dr[1] = -D;
		arr[S] = 1;
		queue = new LinkedList<>();
		queue.add(S);
		bfs();
		if(flag) {
			System.out.println(arr[G]-1);			
		}
		else {
			System.out.println("use the stairs");
		}

	}
}
