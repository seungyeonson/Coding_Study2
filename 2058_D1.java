import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int n = sc.nextInt();
		while(n>0) {
			answer += (n % 10);
			n = n / 10;
		}
		System.out.println(answer);
		
	}
}