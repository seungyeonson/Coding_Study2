import java.util.Queue;
import java.util.Scanner;

public class baek_1463 {
	static int Max = 1000001;
	static int answer;
	static int[] arr = new int[Max];
	static int N;
	static void dfs(int temp, int cnt) {
		if(temp == 1) {
			if(answer>cnt) {
				answer = cnt;
			}
			
			return;
		}
		if(cnt>answer) {
			return;
		}
			for(int i=0;i<3;i++) {
				if(i==0 && temp%3==0&&arr[temp/3]==0) {
					arr[temp/3] = arr[temp]+1;
					dfs(temp/3, cnt+1);
					arr[temp/3] = 0;
				}
				else if(i==1 && temp%2==0&&arr[temp/2]==0) {
					arr[temp/2] = arr[temp]+1;
					dfs(temp/2, cnt+1);
					arr[temp/2] = 0;
				}
				else if(i==2&&arr[temp-1]==0) {
					arr[temp-1] = arr[temp]+1;
					dfs(temp-1, cnt+1);
					arr[temp-1] = 0;
				}
			}
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = Max;
		arr[N] = 0;
		dfs(N,0);
		System.out.println(answer);
	}
	
}
