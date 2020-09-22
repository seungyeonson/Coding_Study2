package IM;
//백준 2309 일곱 난쟁이 
import java.util.Arrays;
import java.util.Scanner;

public class baek_2309 {
	static int N = 9, R = 7, arr[];
	static int[] select;
	static boolean check = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		select = new int[R];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Combination(0, 0, 0);
	}

	static void Combination(int idx, int idx_s, int sum) {
		if (idx_s == R) {
			// System.out.println(Arrays.toString(select));
			if (sum == 100 && check) {
				Arrays.sort(select);
				for (int i = 0; i < R; i++) {
					System.out.println(select[i]);
				}
				check = false;
			}
			return;
		}
		if (sum > 100 || idx == N) {
			return;
		}
		select[idx_s] = arr[idx];
		Combination(idx + 1, idx_s + 1, sum + arr[idx]);
		Combination(idx + 1, idx_s, sum);
	}
}
