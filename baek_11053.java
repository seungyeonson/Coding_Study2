import java.util.Arrays;
import java.util.Scanner;

public class baek_11053 {
	static int N, arr[], answer, dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//N is array size, arr is array with size N
		N = sc.nextInt();
		arr = new int[N+1];
		
		//input
		for(int i=1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		
		//variable initialization
		answer = 0;
		dp = new int[1001];
		
		//algorightm
		for(int i=1;i<=N;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					if(max<dp[j]) {
						max = dp[j];
					}
				}
			}
			dp[i] = max+1;
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
		
	}
}
