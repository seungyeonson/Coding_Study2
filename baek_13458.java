import java.util.Scanner;

public class baek_13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		long answer = 0;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		for(int i=0;i<N;i++) {
			if(arr[i]<=B) {
				answer+=1;
				continue;
			}
			answer+=1;
			answer+=(int)Math.ceil((double)(arr[i]-B)/C);
			
		}
		System.out.println(answer);
	}
}
