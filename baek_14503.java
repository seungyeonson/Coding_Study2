import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14503 {
	static int N, M, map[][], answer, start_x, start_y, direction;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		answer = 1;

		st = new StringTokenizer(in.readLine());

		start_x = Integer.parseInt(st.nextToken());
		start_y = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		visited[start_x][start_y] = true;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(start_x, start_y, direction, 0);
		System.out.println(answer);
	}

	static void dfs(int x, int y, int d, int turn) {
		if(turn==4) {
			x = x-dr[d];
			y = y-dc[d];
			turn = 0;
			if(x<0 || x>=N || y <0 || y>=M || map[x][y]==1) {
				return;
			}
		}
		int nd = (d+3)%4;
		int nx = x+dr[nd];
		int ny = y+dc[nd];
		if(0<=nx && nx<N && 0<=ny && ny<M && !visited[nx][ny] && map[nx][ny]==0) {
			answer+=1;
			visited[nx][ny] = true;
			dfs(nx,ny,nd,0);
		}else {
			dfs(x,y,nd,turn+1);
		}
	}
}
