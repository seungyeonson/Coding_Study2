import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17779 {
	// 각 선거구는 5개의 선거구로 나눈다.
	// 각 구역은 모두 5개의 선거구로 포함되야한다.
	// 선거구는 구역을 적어도 하나 포함해야 한다.
	// 어느 구역에 포함되는지 체크하는 함수
	// 인구수*구역개수까지 가져갔으면 좋겠다
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static int N;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;

	static void dfs(int x, int y, int d1, int d2) {
		if (y - d1 < 0 || y + d2 >= N || x + d1 + d2 >= N) {
			return;
		}
		if (x > N || y > N)
			return;
		//System.out.println(x + " " + y + " " + d1 + " " + d2);
		answer = Math.min(answer, check(x,y,d1,d2));
		//System.out.println(check(x,y,d1,d2));
		dfs(x, y, d1, d2 + 1);
		dfs(x, y, d1 + 1, d2);
	}

	static int check(int x, int y, int d1, int d2) {
		int A = 0, B = 0, C = 0, D = 0, E = 0, max, min;
		int[] arr = new int[5];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		//if(x==1 && y==4 && d1==3&&d2==2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//i 가 x부터 x+d1까지
				if(x<=i && i<=x+d1) {
					if(i<=x+d2 && y-(i-x)<=j && j<=y+(i-x)) {
						arr[4]+=map[i][j];
						//System.out.println(i+"c"+j);
						continue;
					}else if(i>x+d2 && y-(i-x)<=j && j<= y+d2-(i-(x+d2))) {
						arr[4]+=map[i][j];
						//System.out.println(i+"c"+j);
						continue;
					}
				}
				if(x+d1<i && y-d1+(i-(x+d1))<=j && j<= y+d2-(i-(x+d2))) {
					arr[4]+=map[i][j];
					//System.out.println(i+"c"+j);
					continue;
				}
				if (0 <= i && i < x + d1 && 0 <= j && j <= y) {
					arr[0]+=map[i][j];
				} else if (0 <= i && i <= x + d2 && y < j && j <= N - 1 ) {
					arr[1]+=map[i][j];
				} else if (x + d1 <= i && i <= N - 1 && 0 <= j && j < y - d1 + d2) {
					arr[2]+=map[i][j];
					//System.out.println(i+"c"+j);
				} else if (x + d2 < i && i <= N - 1 && y - d1 + d2 <= j && j <= N - 1) {
					arr[3]+=map[i][j];
					//System.out.println(i+"d"+j);
				}
			}
		}
		Arrays.sort(arr);
		//System.out.println(A + " " + B + " " + C + " " + D + " " + E);
		//}
		return arr[4] - arr[0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j, 1, 1);

			}
		}
		System.out.println(answer);

	}
}
