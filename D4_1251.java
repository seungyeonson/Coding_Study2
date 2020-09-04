import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//하나로
//환경 부담금을 최소로 하는 해저터널을 설계
//환경부담금은 환경부담세율 * 길이의 제곱이므로 길이를 작게 해야한다.
//
public class D4_1251 {
	static int N, arr[][];
	static long adjMatrix[][];
	static double E;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			arr = new int[N][2];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			adjMatrix = new long[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = adjMatrix[j][i] = distance(arr[i][0], arr[j][0], arr[i][1], arr[j][1]);
				}
			}
			E = Double.parseDouble(in.readLine().trim());
			// 이미 선택된 애들 넣어놓기 위해 배열을 만들자

			System.out.println("#" + tc + " " + Math.round(E*makeMST()));
		} // test case end

	}// main end
	private static long makeMST() {
		boolean[] visit = new boolean[N];
		long[] minEdge = new long[N];

		long result = 0;
		int cnt = 0;
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;
		while (true) {
			long min = Long.MAX_VALUE;
			int minNo = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i] && min > minEdge[i]) {
					min = minEdge[i];
					minNo = i;
				}
			}

			visit[minNo] = true;
			result += min;
			if (++cnt == N)
				break;

			for (int i = 0; i < N; i++) {
				if (!visit[i] && adjMatrix[minNo][i] > 0 && minEdge[i] > adjMatrix[minNo][i]) {
					minEdge[i] = adjMatrix[minNo][i];
				}
			}
		}
		return result;
	}

	private static long distance(int i, int j, int k, int l) {
		return (long) (Math.pow((i - j),2) + Math.pow((k - l),2));

	}
}
