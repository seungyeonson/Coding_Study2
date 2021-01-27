
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


//11286 백준 절댓값 힙
//우선순위큐가 힙으로 만들어졌기 때문에 우선순위큐를 활용한다.
public class baek_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) {
					return Integer.compare(o1, o2);
				}
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
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
