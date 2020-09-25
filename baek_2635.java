package IM;

import java.util.Arrays;
import java.util.Scanner;

public class baek_2635 {
	static int N, select[], answer, ans_select[];
	static boolean flag = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = 0;
		ans_select = new int[30000];
		select = new int[30000];
		if (N > 2) {
			for (int i = N / 2; i < N; i++) {
				if (i == 0) {
					continue;
				}
				Arrays.fill(select, -1);
				go(N, i);
			}
		}
		else if(N>0) {
			for (int i = 1; i <= N; i++) {
				Arrays.fill(select, -1);
				go(N, i);
			}
		}
		System.out.println(answer);
		for (int i = 0; i < ans_select.length; i++) {
			if (ans_select[i] == -1) {
				break;
			}
			System.out.print(ans_select[i] + " ");
		}
		System.out.println();
	}

	private static void go(int n2, int i) {
		int cnt = 0;
		while (n2 >= 0) {
			select[cnt] = n2;
			int temp = n2;
			n2 = i;
			i = temp - i;
			cnt++;
		}

		if (answer <= cnt) {
			answer = cnt;
			ans_select = select.clone();
		}

	}
}
