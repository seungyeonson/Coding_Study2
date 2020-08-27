import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 빵집
public class baek_3109 {
	static char[][] arr;
	static int[] sel;
	static int R, C;
	static int answer;
	static int[] dr = { -1, 0, 1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];
		sel = new int[C];
		for (int i = 0; i < R; i++) {
			arr[i] = in.readLine().toCharArray();
		}
		visit = new boolean[R][C];
		pipe();
		System.out.println(answer);

	}

	static void pipe() {
		// 0열의 모든 행의 위치에서 파이프 놓기 시작
		for (int i = 0; i < R; i++) {
			visit[i][0] = true;
			go(i,0);
		}
	}

	// 현 위치에서 오른쪽 대각선위, 오른쪽, 오른쪽 아래 순서적으로 파이프 연결 시도
	static boolean go(int r, int c) {
		int nr,nc=c+1;
		if(c == C-1) {
			answer++;
			return true;
		}
		for(int i=0;i<3;i++) {
			nr = r+dr[i];
			if(nr<0 || nr>=R || visit[nr][nc]||arr[nr][nc]=='x') continue;
			visit[nr][nc] = true;
			if(go(nr,nc)) return true;
			
		}
		return false;
	}
}
