import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사_4012 {
	static int N;
	static int[][] arr;
	static int[] mat;
	static int index;
	static int[] select, select_2, select_3;
	static int answer, number_1, number_2;
	public static void combination_2(int idx, int cnt) {
		if (cnt == 2) {
			number_1 += arr[select[select_3[0]]][select[select_3[1]]]+arr[select[select_3[1]]][select[select_3[0]]];
			number_2 += arr[select_2[select_3[0]]][select_2[select_3[1]]]+arr[select_2[select_3[1]]][select_2[select_3[0]]];
			return;
		}
		if (idx == N/2) {
			return;
		}
		select_3[cnt] = idx;
		combination_2(idx + 1, cnt + 1);
		combination_2(idx + 1, cnt);
	}

	// 4c2
	public static void combination(int idx, int cnt) {
		if (cnt == N/2) {
			index = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N/2;j++) {
					if(select[j]==i) break;
					if(j==N/2-1) select_2[index++] = i;
				}
			}
			number_1 = 0;
			number_2 = 0;
			combination_2(0,0);
			answer = Math.min(answer, Math.abs(number_1-number_2));
			return;
		}
		if (idx == N) {
			return;
		}
		select[cnt] = idx;
		combination(idx + 1, cnt + 1);
		combination(idx + 1, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			index = 0;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			mat = new int[N * (N - 1) / 2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 10000000;
			select = new int[N/2];
			select_2 = new int[N/2];
			select_3 = new int[2];
			combination(0, 0);

			System.out.println("#" + tc + " " + answer);
		}
	}
}
