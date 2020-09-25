package IM;
//자리배정
import java.util.Arrays;
import java.util.Scanner;

public class baek_10157 {
	static int[] dr = { 0, 1, -1, 0 };
	static int[] dc = { 1, 0, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[C][R];
		int number = 1;
		arr[0][0] = number;
		int c = 0;
		int r = 0;
		int temp = 0;
		boolean flag = true;
		if (K > C * R) {
			flag = false;
		}
		while (number < K && flag) {
			c = c + dr[(temp) % 4];
			r = r + dc[(temp) % 4];
			if (r < 0 || r >= R || c < 0 || c >= C || arr[c][r] != 0) {
				c = c - dr[(temp) % 4];
				r = r - dc[(temp) % 4];
				temp++;
				continue;
			}
			number++;
			arr[c][r] = number;

		}
		if(flag)
			System.out.println((c + 1) + " " + (r + 1));
		else {
			System.out.println(0);
		}
	}
}
