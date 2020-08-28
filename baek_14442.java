//벽 부수고 이동하기 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class baek_14442 {
	static int N, M, K, answer;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<int[]> queue;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean flag;
	static void bfs() {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0]==N-1 && now[1]==M-1) {
				answer = now[2];
				flag = true;
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = now[0]+dr[i];
				int ny = now[1]+dc[i];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(visit[nx][ny][now[3]]) continue;
				if(map[nx][ny]==0) {
					queue.add(new int[] {nx,ny,now[2]+1,now[3]});
					visit[nx][ny][now[3]] = true;
				}
				if(map[nx][ny]==1 && now[3]<K) {
					queue.add(new int[] {nx,ny,now[2]+1,now[3]+1});
					visit[nx][ny][now[3]+1] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1, 0 });
		visit[0][0][0] = true;
		bfs();
		if(flag)
			System.out.println(answer);
		else System.out.println(-1);
	}
}

