package IM;

import java.util.Scanner;

public class baek_2116 {
	static int[] t = { 5, 3, 4, 1, 2, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][6];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
			arr[i][3] = sc.nextInt();
			arr[i][4] = sc.nextInt();
			arr[i][5] = sc.nextInt();
		}
		// 첫 주사위로 인덱스 0,5를 선택하는 경우
		// 첫 주사위로 인덱스 1,3을 선택하는 경우
		// 첫 주사위로 인덱스 2,4를 선택하는 경우
		for (int i = 0; i < 6; i++) {
			int bottom = arr[0][i];
			int top = arr[0][t[i]];
			int count = 0;
			for (int j = 0; j < N; j++) {
				int max = 0;
				if(j>0) {
					bottom = top;
					for(int d = 0;d<6;d++) {
						if(arr[j][d]==bottom) {
							top = arr[j][t[d]];
						}
					}
				}
				for (int k = 0; k < 6; k++) {
					if (arr[j][k] == bottom || arr[j][k] == top) {
						continue;
					}
					max = Math.max(max, arr[j][k]);
				}
				count += max;

			}
			answer = Math.max(count, answer);
		}
		System.out.println(answer);
	}
}
