import java.util.Scanner;

//한수
public class baek_1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		if(N<100) {
			answer = N;
		}else {
			answer+=99;
			for(int i=100;i<=N;i++) {
				if(i==1000)continue;
				int a = (i/100)%10;
				int b = (i/10)%10;
				int c = i%10;
				//System.out.println(a+" "+b+" "+c);
				if(a-b ==b-c) {
					answer++;
				}
			}
		}
		System.out.println(answer);
		
		
	}
}
