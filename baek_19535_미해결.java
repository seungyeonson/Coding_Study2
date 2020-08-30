import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//ㄷㄷㄷㅈ
// 트리의 순회=> ㄷ은 dfs로 4번 가도록 하고 처음 원소를 visit처리
//			ㅈ은 bfs로 1번씩만 갔을 때 원소가 3개 이상 있는지???
public class baek_19535_미해결 {
	static ArrayList<Integer>[] arr;
	static ArrayList<int[]> conect;
	static int N, d, g;

	static int bfs(int start) {
		int answer = arr[start].size() - 3 >= 0
				? arr[start].size() * (arr[start].size() - 1) * (arr[start].size() - 2) / 6
				: 0;
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		conect = new ArrayList<>();
		for (int i = 0; i < N + 1; i++)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
			conect.add(new int[] { from, to });
		}
		for (int i = 1; i < N + 1; i++) {
			g += bfs(i);
		}
		for (int[] now : conect) {
			int temp = (arr[now[0]].size() - 2) >= 0 ? arr[now[0]].size() - 1 : 0;
			int temp_1 = (arr[now[1]].size() - 2) >= 0 ? arr[now[1]].size() - 1 : 0;
			d += temp * temp_1;
		}
		if (d == (3 * g)) {
			System.out.println("DUDUDUNGA");
		} else if (d > (3 * g)) {
			System.out.println("D");
		} else if (d < (3 * g)) {
			System.out.println("G");
		}
//		System.out.println(d);
//		System.out.println(g);

	}
}
