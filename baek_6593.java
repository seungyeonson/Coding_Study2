import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class baek_6593 {

	static int df[] = { 1, -1, 0, 0, 0, 0 };
	static int dr[] = { 0, 0, 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 0, 0, 1, -1 };

	static int visit[][][];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out: while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int floor = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			if (floor == 0 && row == 0 && col == 0)
				break out;

			char[][][] first = new char[floor][row][col];
			Queue<int[]> hanab = new LinkedList<>();
			visit = new int[floor][row][col];

			for (int i = 0; i < floor; i++) {
				for (int j = 0; j < row; j++) {
					String line = br.readLine();
					first[i][j] = line.toCharArray();
					for (int k = 0; k < col; k++) {
						if (first[i][j][k] == 'S') {
							visit[i][j][k] = 1;
							hanab.add(new int[] { i, j, k, 0 });
						}
					}
				}
				br.readLine();
			}

			int count = 0;

			boolean flag = false;

			while (!hanab.isEmpty()) {
				int[] hi = hanab.poll();
				if (first[hi[0]][hi[1]][hi[2]] == 'E') {
					count = hi[3];
					flag = true;
					break;
				}

				for (int i = 0; i < 6; i++) {
					int ff = hi[0] + df[i];
					int rr = hi[1] + dr[i];
					int cc = hi[2] + dc[i];

					if (ff >= 0 && rr >= 0 && cc >= 0 && ff < floor && rr < row && cc < col && visit[ff][rr][cc] == 0
							&& first[ff][rr][cc] != '#') {
						visit[ff][rr][cc] = 1;
						int hehe = hi[3] + 1;
						hanab.add(new int[] { ff, rr, cc, hehe });
					}
				}

			}
			if (flag)
				System.out.println("Escaped in " + count + " minute(s).");
			else
				System.out.println("Trapped!");
		}
	}
}
