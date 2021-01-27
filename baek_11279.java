
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


//11279 백준 최대 힙
//우선순위큐가 힙으로 만들어졌기 때문에 우선순위큐를 활용한다.
public class baek_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(br.readLine());
			if (now == 0 && heap.isEmpty()) {
				System.out.println(0);
			} else if (now == 0) {
				System.out.println(heap.remove());
			} else {
				heap.add(now);
			}
		}
	}
}
