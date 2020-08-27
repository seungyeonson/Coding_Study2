import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳 숙제
public class baek_1987 {
	static int R, C, answer;
	static char[][] map;
	static boolean[] visit;
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visit = new boolean[26];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		visit[map[0][0] - 'A'] = true;
		go(0, 0, 1);
		System.out.println(answer);
	}

	static void go(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (visit[map[nx][ny] - 'A'])
				continue;
			visit[map[nx][ny] - 'A'] = true;
			go(nx, ny, cnt+1);
			visit[map[nx][ny]-'A'] = false;
		}
	}
}
