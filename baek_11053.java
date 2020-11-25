import java.util.Arrays;
import java.util.Scanner;

//백준 알고리즘 11053
//처음 접근 방식=>부분집합을 통해 접근
//가장 긴 증가하는 부분 수열
//접근 방식=>증가하는 원소를 가진 부분 집합을 만들자
//=>부분 집합을 만들되 다음 선택 원소가 이전 원소가보다 증가하면 ok 아니면  return

//두번째 접근=>DP를 통한 접근=>왜냐하면 N이 1000까지 증가한다면 시간복잡도가 2^1000이므로 최대 N^2이 되도록 해야함.


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
			int min = 0;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					if(min<dp[j]) {
						min = dp[j];
					}
				}
			}
			dp[i] = min+1;
			answer = Math.max(answer, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(answer);
		
	}
}
