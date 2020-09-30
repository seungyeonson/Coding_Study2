import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_17135 {
	static int N, M, D, map[][], castle[][], answer, count;
	static int[] dr = { 0, -1, 0 };
	static int[] dc = { -1, 0, 1 };
	static boolean[][] visited;
	static Queue<int[]> shoot;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		castle = new int[N + 1][M];
		answer = 0;
		shoot = new LinkedList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Combination(0, 0);
		System.out.println(answer);
	}

	private static void Combination(int idx, int idx_s) {
		if (idx_s == 3) {
			//System.out.println(Arrays.toString(map[N]));
			for (int i = 0; i < N + 1; i++) {
				castle[i] = map[i].clone();
			}
			count = 0;
			defense(castle);
			//System.out.println(count);
			answer = Math.max(answer, count);
			return;
		}
		if (idx == M) {
			return;
		}
		map[N][idx] = 2;
		Combination(idx + 1, idx_s + 1);
		map[N][idx] = 0;
		Combination(idx + 1, idx_s);

	}

	private static void defense(int[][] arr) {
		while (check(arr)) {
			for (int i = 0; i < M; i++) {
				if (arr[N][i] == 2) {
					Queue<int[]> queue = new LinkedList<>();
					visited = new boolean[N+1][M];
					Arrays.fill(visited[N], true);
					queue.add(new int[] { N, i,0 });
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						//System.out.println(now[0]+" "+now[1]);
						if(now[2]>D) {
							break;
						}
						if(arr[now[0]][now[1]]==1) {
							shoot.add(new int[] {now[0],now[1]});
							break;
						}
						for(int d = 0;d<3;d++) {
							int nx = now[0]+dr[d];
							int ny = now[1]+dc[d];
							
							if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
								queue.add(new int[] {nx,ny,now[2]+1});
							}
						}
					}
				}
			}
			up(arr);
		}

	}

	private static void up(int[][] arr) {
		for(int[] temp:shoot) {
			if(arr[temp[0]][temp[1]]==1) {
				count++;
			}
			arr[temp[0]][temp[1]] = 0;
		}
		shoot = new LinkedList<int[]>();
		for (int i = N - 1; i > 0; i--) {
			arr[i] = arr[i - 1].clone();
		}
		Arrays.fill(arr[0], 0);
	}

	private static boolean check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}
}
