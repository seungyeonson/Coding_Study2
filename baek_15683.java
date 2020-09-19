import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//감시
public class baek_15683 {
	static int N, M, map[][], answer;
	static List<int[]> list;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new int[] { i, j });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		cctv(0);
		System.out.println(answer);

	}

	static void cctv(int idx) {
		if (idx == list.size()) {
			answer = Math.min(answer, check());
			return;
		}
		int x = list.get(idx)[0];
		int y = list.get(idx)[1];
		if (map[x][y] == 1) {
			for (int i = 0; i < 4; i++) {
				go(x, y, i, true);
				cctv(idx + 1);
				go(x, y, i, false);
			}
		} else if (map[x][y] == 2) {
			for (int i = 0; i < 2; i++) {
				go(x, y, i, true);
				go(x, y, i + 2, true);
				cctv(idx + 1);
				go(x, y, i, false);
				go(x, y, i + 2, false);
			}
		} else if (map[x][y] == 3) {
			for (int i = 0; i < 4; i++) {
				go(x, y, i, true);
				go(x, y, (i + 1)%4, true);
				cctv(idx + 1);
				go(x, y, i, false);
				go(x, y, (i + 1)%4, false);
			}
		} else if (map[x][y] == 4) {
			for (int i = 0; i < 4; i++) {
				go(x, y, i, true);
				go(x, y, (i + 1)%4, true);
				go(x, y, (i + 2)%4, true);
				cctv(idx + 1);
				go(x, y, i, false);
				go(x, y, (i + 1)%4, false);
				go(x, y, (i + 2)%4, false);
			}
		} else if (map[x][y] == 5) {
			for (int i = 0; i < 4; i++) {
				go(x, y, i, true);
			}
			cctv(idx + 1);
			for (int i = 0; i < 4; i++) {
				go(x, y, i, false);
			}
		}

	}

	static void go(int x, int y, int d, boolean b) {
		x = x + dr[d];
		y = y + dc[d];
		while (x >= 0 && x < N && y >= 0 && y < M && map[x][y]!=6) {
			if (map[x][y] <= 0 && b) {
				map[x][y] -= 1;
			} else if (map[x][y] <= -1 && !b) {
				map[x][y] += 1;
			}
			x = x + dr[d];
			y = y + dc[d];
		}
	}

	static int check() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		return count;
	}
}
