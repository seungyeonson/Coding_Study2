package IM;

import java.util.Arrays;
import java.util.Scanner;

public class baek_10163 {
	static int N, count[], temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		temp = 0;
		int paper[][] = new int[101][101];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			temp++;
			for (int j = a; j < a + c; j++) {
				for (int k = b; k < b + d; k++) {
					paper[j][k] = temp;
				}
			}
		}
		count = new int[N];
		check(paper);
		for (int i = 0; i < N; i++) {

			System.out.println(count[i]);
		}
	}

	private static void check(int[][] paper) {
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (paper[i][j] != 0) {
					count[paper[i][j] - 1]++;
				}
			}
		}
	}
}
