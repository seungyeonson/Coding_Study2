import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_17471 {
	static int N;
	static boolean[][] map;
	static int[] ingu;
	static int answer;
	static boolean[] select;

	static void powerSet(int idx, int A_num, int B_num) {
		if (idx == N + 1) {
			
			if (check()) {
//				for(int i=1;i<N+1;i++) {
//					if(select[i]) {
//						System.out.print(i+" ");
//					}
//				}
//				System.out.println();
//				System.out.println(A_num+" "+B_num);
				answer = Math.min(answer, Math.abs(A_num - B_num));
			}
			return;
		}

		select[idx] = true;
		powerSet(idx + 1, A_num + ingu[idx], B_num);
		select[idx] = false;
		powerSet(idx + 1, A_num, B_num + ingu[idx]);

	}

	static boolean check() {
		boolean[] check = new boolean[N + 1];

		int A = -1, B = -1;
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				A = i;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!select[i]) {
				B = i;
				break;
			}
		}
		if (A == -1 || B == -1)
			return false;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(A);
		check[A] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (select[i]&&!check[i] && map[now][i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
		queue = new LinkedList<>();
		queue.add(B);
		check[B] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!select[i]&&!check[i] && map[now][i]) {
					queue.add(i);
					check[i] = true;
				}
			}
		}
//		System.out.println("Hello");
		//System.out.println(Arrays.toString(check));
		for (int i = 1; i <= N; i++) {
			if (!check[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		ingu = new int[N + 1];
		map = new boolean[N + 1][N + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N + 1; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				int to = Integer.parseInt(st.nextToken());
				map[i][to] = true;
			}
		}
		answer = Integer.MAX_VALUE;
		select = new boolean[N + 1];
		powerSet(1, 0, 0);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

	}
}
