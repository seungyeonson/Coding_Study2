package _0922;

import java.util.Scanner;

//2xn타일링
public class baek_11726 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[1001];
		
		System.out.println(tile(N));
	}

	public static int tile(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (arr[n] > 0) {
			return arr[n];
		}

		arr[n] = tile(n-2)+tile(n-1);

		arr[n] %= 10007;
		return arr[n];
	}
}
