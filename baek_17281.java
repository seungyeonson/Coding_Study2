import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//야구
public class baek_17281 {
	static int N, K, answer;
	static int[] select;
	static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[][] ening;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = 9;
		answer = 0;
		ening = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				ening[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation(arr, 0, K - 1);
		System.out.println(answer);
	}

	static void swap(int[] str, int x, int y) {
		int temp = str[x];
		str[x] = str[y];
		str[y] = temp;
	}

	static void permutation(int[] str, int l, int r) {
		if (l == r && str[3] == 1) {
			//System.out.println(Arrays.toString(str));
			answer = Math.max(answer, play(str));
		} else {
			for (int i = l; i <= r; i++) {
				swap(str, l, i);
				permutation(str, l + 1, r);
				swap(str, l, i); // backtrack
			}
		}
	}

	private static int play(int[] str) {
		// 총 이닝 수
		int now = 0;
		int runner_1 = 0;
		int runner_2 = 0;
		int runner_3 = 0;
		int score = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			while (out < 3) {

				now = now % 9;
				if (ening[i][str[now]-1] == 0) {
					out++;
					now++;
					continue;
				}
				else if(ening[i][str[now]-1]==1) {
					score += runner_3;
					runner_3 = runner_2;
					runner_2 = runner_1;
					runner_1 = 1;
				}else if(ening[i][str[now]-1]==2) {
					score+=(runner_3+runner_2);
					runner_3 = runner_1;
					runner_2 = 1;
					runner_1 = 0;
				}else if(ening[i][str[now]-1]==3) {
					score+=(runner_1+runner_2+runner_3);
					runner_3 = 1;
					runner_2 = 0;
					runner_1 = 0;
				}else if(ening[i][str[now]-1]==4) {
					score+=(runner_1+runner_2+runner_3+1);
					runner_3 = 0;
					runner_2 = 0;
					runner_1 = 0;
				}
				now++;
			}
			runner_1 = 0;
			runner_2 = 0;
			runner_3 = 0;
		}
		return score;
	}

}
