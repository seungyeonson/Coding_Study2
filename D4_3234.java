import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//준환이의 양팔저울
public class D4_3234 {
	static int answer, N;
	static int[] arr, sel;
	static boolean[] visit;
	static void powerSet(int idx, int idx_s, int sum_L,int  sum_R) {
		if(sum_L<sum_R) {
			return;
		}
		if(idx==N) {
			answer++;
			//System.out.println(sum_L+" "+sum_R);
			return;
		}

		powerSet(idx+1,idx_s+1, sum_L+sel[idx], sum_R);
		
		powerSet(idx+1,idx_s,sum_L, sum_R+sel[idx]);
	}
	static void permutation(int idx) {
		if (idx == N) {
			//System.out.println(Arrays.toString(sel));
			powerSet(0,0,0,0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sel[idx] = arr[i];
				permutation(idx+1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			visit = new boolean[N];
			arr = new int[N];
			sel = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			permutation(0);
			System.out.println("#" + tc + " " + answer);
		}
	}
}
