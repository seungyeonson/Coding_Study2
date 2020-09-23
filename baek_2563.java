package IM;

import java.util.Scanner;

public class baek_2563 {
	static int N = 100;
	static boolean[][] fin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		fin = new boolean[N][N];
		int R = sc.nextInt();
		for (int i = 0; i < R; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			go(x, y);
		}
		System.out.println(check());

	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (fin[i][j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void go(int x, int y) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				fin[x + i][y + j] = true;
			}
		}
	}
}
