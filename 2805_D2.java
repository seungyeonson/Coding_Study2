package test;

import java.util.*;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[] temp = new int[N];
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					temp[i] = 1;
				} else if (i <= N / 2) {
					temp[i] = temp[i - 1] + 2;
				} else {
					temp[i] = temp[i - 1] - 2;
				}
			}
			for (int i = 0; i < N; i++) {
				String line = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			int[] start = { 0, N / 2 };
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < temp[i]; k++) {
					answer += arr[i][start[1] + k];
				}
				if (i < N / 2) {
					start[0] += 1;
					start[1] -= 1;
				} else if (i >= N / 2) {
					start[0] += 1;
					start[1] += 1;
				}

			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
