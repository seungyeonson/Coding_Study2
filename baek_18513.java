import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//치킨 먹고 싶다!!
//마을에 집을 지을 때 치킨 지수가 작을수록 행복하므로 치킨지수가 최소가 되도록 한다.
public class Algo3_광주_2반_송승연 {
	static int[] dr = { -1, 1 };

	public static void main(String[] args) throws IOException {
		// 자바 Input 처리
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		// 입력에 따른 변수 저장
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 집을 저장하기 위한 변수로 치킨집의 범위가 -100000000 ~ 100000000이므로 0~200000000으로 바꾸어 저장한다.
		boolean[] visit = new boolean[200000001];
		// 치킨집을 위한 변수 총 N개가 저장된다.
		// int[] chicken_house = new int[N];
		Queue<int[]> queue = new LinkedList<>();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int chicken = Integer.parseInt(st.nextToken());
			// 치킨집에 입력값에 100000000을 더해서 저장하고 map에는 치킨집을 -1로 저장한다.
			queue.add(new int[] { chicken + 100000000, 0 });
			visit[chicken + 100000000] = true;
		}
		// 정답을 0으로 초기화
		long answer = 0;
		int cnt = 0;
		// 무조건 집을 K개 지으면 루프가 끝나도록 한다.
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (cnt == K) {
				break;
			}
			for (int i = 0; i < 2; i++) {
				int nx = now[0] + dr[i];
				if (0 <= nx && nx <= 200000000 && !visit[nx]) {
					queue.add(new int[] { nx, now[1] + 1 });
					visit[nx] = true;
					answer += now[1]+1;
					cnt++;
				}
				if (cnt == K) {
					break;
				}
			}
		}
		System.out.println(answer);

	}
}
