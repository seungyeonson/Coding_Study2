import java.util.Arrays;
import java.util.Scanner;

public class D4_4796 {
	static int N, answer, arr[], select[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			select = new int[2];
			answer = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			check();
			System.out.println("#" + tc + " " + answer);
		} // end tc
	}// end main

	static void check() {
		int front = 0, back = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] < arr[i]) {
				if(front==0 && back>0) {
					back=0;
				}
				else if(front>0 && back>0) {
					answer+=front*back;
					front=0;
					back=0;
				}
			}
			if(arr[i-1]<arr[i]) {
				front++;
			}else {
				back++;
			}
		}
		if(front >0 && back>0) {
			answer += front*back;
		}
		
	}
}
