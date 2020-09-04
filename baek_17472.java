import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다리만들기2
//섬의 개수가 최대 6개이니 섬을 저장하는 것을 6개로 해놔야겠다.
//먼저 섬의 개수를 세야하고 IsCnt
//그럼 섬을 담을 때 IsCnt가 커지면서 x,y를 담는게 좋을 것 같은데...
//ArrayList[IsCnt].add(x,y)이런 느낌으로 들어가게??
//섬과 섬과의 거리름 담을 것을 만들어야할 것 같다. 거리는 2이상이다. 명심할것
//다리를 놓을 때는 방향이 일치해야한다.
//섬과 섬과의 거리를 만들때는 어레이 리스트를 반복시키면서 만들수 있을 것 같다.
//거리가 생긴다면 클래스를 새로 만들어서 끝나는 점 거리를 담을 수 있도록 한다.
//Node[시작점] = new Node(끝나는점, 거리)가 될 수 있도록
//그러면 Node는 정렬할 수 있어야하고 현재 노드[]에는 다리를 놓을 수 있는 모든 조합이 있고
//나는 다리를 놓을 때 최소값이되면서 다리를 놓아야하므로 프림과 같은 방법을 쓴다.
public class baek_17472 {
	static int N, M, arr[][], IsCnt, adjMatrix[][], bfs[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<int[]> iqueue;
	static boolean visit[][];
	static ArrayList<int[]>[] Island;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		adjMatrix = new int[7][7];
		bfs = new int[N][M];
		Island = new ArrayList[7];
		for (int i = 0; i < 7; i++) {
			Island[i] = new ArrayList<>();
		}
		visit = new boolean[N][M];
		iqueue = new LinkedList<>();
		// 섬을 찾고 섬을 배열에 넣기
		findIsland();
//		System.out.println(IsCnt);
//		for(int i=1;i<=IsCnt;i++) {
//			System.out.println(Arrays.toString(Island[i].get(0)));
//		}
		// 섬끼리의 거리 구하기
		distance();
//		for (int i = 1; i <= 6; i++) {
//			System.out.println(Arrays.toString(adjMatrix[i]));
//		}
		System.out.println(makeMST());
	}// end main

	static void findIsland() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					iqueue.add(new int[] { i, j });
					visit[i][j] = true;
					IsCnt++;
					Island[IsCnt].add(new int[] { i, j, IsCnt });
					bfs[i][j] = IsCnt;
					while (!iqueue.isEmpty()) {
						int[] now = iqueue.poll();
						int x = now[0];
						int y = now[1];
						for (int d = 0; d < 4; d++) {
							int nx = x + dr[d];
							int ny = y + dc[d];
							if (nx < 0 || ny < 0 || nx >= N || ny >= M)
								continue;
							if (visit[nx][ny])
								continue;
							if (arr[nx][ny] == 0)
								continue;
							iqueue.add(new int[] { nx, ny });
							visit[nx][ny] = true;
							bfs[nx][ny] = IsCnt;
							Island[IsCnt].add(new int[] { nx, ny, IsCnt });
						}
					}
				}
			}
		}
	}// end method

	static void distance() {
		// 첫번째 구역에서 하나 뽑자+ 뽑을 때는 뽑는거의 4방탐색해서 하나가 0이어야한다.
		for (int i = 1; i <= IsCnt; i++) {

			for (int[] now : Island[i]) {
				for (int d = 0; d < 4; d++) {
					int nx = now[0] + dr[d];
					int ny = now[1] + dc[d];
					// 범위밖이거나 1이면 아웃
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if (arr[nx][ny] == 1)
						continue;
					// 탐색할 친구를 찾았다.
					// 같은 방향으로 끝까지 가보자.
					int Count = 1;
					while (true) {
						Count++;
						nx = nx + dr[d];
						ny = ny + dc[d];
						if (nx < 0 || ny < 0 || nx >= N || ny >= M)
							break;
						if (arr[nx][ny] == 1) {
							// 길이가 2인경우는 제외, 만약 인접행렬조회 0인경우는 바로 넣고
							// 0이 아니라 이미 숫자가 있으면 비교해서 작은것 넣기
							if (Count - 1 < 2)
								break;
							if (adjMatrix[i][bfs[nx][ny]] == 0 || adjMatrix[i][bfs[nx][ny]] > Count - 1) {
								adjMatrix[i][bfs[nx][ny]] = adjMatrix[bfs[nx][ny]][i] = Count - 1;
							}
							break;
						}
					}

				}
			}
		}
	}//end method
	private static long makeMST() {
		boolean[] visit = new boolean[7];
		int[] minEdge = new int[7];

		int result = 0;
		int cnt = 0;
		int start = 0;
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		out:for(int i=0;i<7;i++) {
			for(int j=0;j<7;j++) {
				if(adjMatrix[i][j]!=0) {
					start = i;
					//System.out.println(i+" "+j);
					break out;
				}
			}
		}
		minEdge[start] = 0;
		while (true) {
			int min = Integer.MAX_VALUE;
			int minNo = 0;
			for (int i = 1; i < 7; i++) {
				if (!visit[i] && min > minEdge[i]) {
					min = minEdge[i];
					minNo = i;
				}
			}
			if(minNo==0) {
				return -1;
			}

			visit[minNo] = true;
			result += min;
			if (++cnt == IsCnt)
				break;

			for (int i = 1; i < 7; i++) {
				if (!visit[i] && adjMatrix[minNo][i] > 0 && minEdge[i] > adjMatrix[minNo][i]) {
					minEdge[i] = adjMatrix[minNo][i];
				}
			}
		}
		return result;
	}
}
