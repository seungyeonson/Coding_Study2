import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16236 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int eat = 0;
		int cnt = 0;

		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					queue.add(new int[] { i, j, 2, 0 });
					arr[i][j] = 0;

				}
			}
		}
		while (true) {
			int[] shark = queue.peek();
			LinkedList<int[]> fish = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];
			while (!queue.isEmpty()) {
				int[] baby = queue.poll();
				int x = baby[0];
				int y = baby[1];
				int size = baby[2];
				int dist = baby[3];
				for (int i = 0; i < 4; i++) {
					int nx = x + dr[i];
					int ny = y + dc[i];
					//System.out.println(nx + " " + ny + " " + size + " " + eat);
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					if (arr[nx][ny] > size)
						continue;
					if(visited[nx][ny])
						continue;
					if (arr[nx][ny] == size || arr[nx][ny] == 0) {
						queue.add(new int[] { nx, ny, size, dist + 1 });
						visited[nx][ny] = true;
					} else if (arr[nx][ny] < size) {
						queue.add(new int[] { nx, ny, size, dist + 1 });
						fish.add(new int[] { nx, ny, size, dist + 1 });
						visited[nx][ny] = true;
					}
				}
			}
			if(fish.size()==0) {
				System.out.println(cnt);
				return;
			}
			int[] eatingfish = fish.get(0);
			for(int i=0;i<fish.size();i++) {
				if(eatingfish[3]>fish.get(i)[3]) {
					eatingfish = fish.get(i).clone();
				}
				if(eatingfish[3]==fish.get(i)[3]) {
					if(eatingfish[0]>fish.get(i)[0]) {
						eatingfish = fish.get(i).clone();
						continue;
					}else if(eatingfish[0]==fish.get(i)[0]) {
						if(eatingfish[1]>fish.get(i)[1]) {
							eatingfish = fish.get(i).clone();
						}
					}
				}
			}
			cnt+=eatingfish[3];
			eat++;
			arr[eatingfish[0]][eatingfish[1]] = 0;
			int temp_age = eatingfish[2];
			if(eat == eatingfish[2]) {
				temp_age+=1;
				eat = 0;
			}
			queue.add(new int[] {eatingfish[0], eatingfish[1],temp_age, 0 });
		}

	}
}
