package IM;

import java.util.Scanner;

//참외밭
public class baek_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[6][2];
		int max_index = 0, answer = 0;
		int max_first = 0, max_second = 0;
		
		for (int i = 0; i < 6; i++) {
			int D = sc.nextInt();
			int R = sc.nextInt();
			arr[i][0] = D;
			arr[i][1] = R;
			if (D == 1 || D == 2) {
				if(max_first<R) {
					max_first = R;
					max_index = Math.max(max_index, i);
				}

			} else if (D == 3 || D == 4) {
				if(max_second<R) {
					max_second = R;
					max_index = Math.max(max_index, i);
				}
			}

		}
		if(max_index==5 && (max_first==arr[0][1]||max_second==arr[0][1])) {
			max_index=0;
		}
		answer = max_first * max_second - (arr[(max_index+2)%6][1] * arr[(max_index+3)%6][1]);
		System.out.println(answer*N);
	}
}
