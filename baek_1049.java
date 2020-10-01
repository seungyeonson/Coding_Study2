import java.util.Scanner;

//기타줄
public class baek_1049 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] price = new int[M][2];
		int answer = Integer.MAX_VALUE;
		int min_package = Integer.MAX_VALUE,min_item =Integer.MAX_VALUE;
		for(int i=0;i<M;i++) {
			price[i][0] = sc.nextInt();
			price[i][1] = sc.nextInt();
			min_package = Math.min(min_package, price[i][0]);
			min_item = Math.min(min_item, price[i][1]);
		}
		int now = (int) Math.min(N*min_item,  min_package*Math.ceil((double)N/6));
		now = Math.min(now, min_package*(N/6)+min_item*(N%6));
		answer = Math.min(answer, now);
		System.out.println(answer);
	}
}
