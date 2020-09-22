package _0922;
//1,2,3더하기
import java.util.Scanner;

public class baek_9095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dp = new int[10];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt();
			for(int i=3;i<N;i++) {
				dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
			}
			System.out.println(dp[N-1]);
		}
	}
}
