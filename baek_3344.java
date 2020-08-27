import java.util.Scanner;

public class Nqueens_3344 {
	static int N;
	static int[] col;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		nqueens();
	}
	static void nqueens() {
		for(int i=1;i<N+1;i++) {
			//N을 6으로 나눈 나머지가 2나 3이 아니라면 짝수-홀수형태
			if( N%6 !=2 && N %6 !=3) {
				if(i*2<=N)
					System.out.println(i*2);
				else {
					System.out.println((i-N/2-1)*2+1);
				}
			}
			// N을 6으로 나눈 나머지가 2이면 홀수리스트에서 1과3을 스왑 5를 가장 마지막으로 보내기
			else if(N%6 ==2) {
				if(i*2<=N)
					System.out.println(i*2);
				else {
					if(i*2-4>N && i<N) {
						System.out.println((i-N/2-1)*2+3);
					}
					else if(i*2-2>N&&i*2-4<=N) {
						System.out.println(1);
					}
					else if(i*2>N && i*2-2<=N) {
						System.out.println(3);
					}
					else if(i==N) {
						System.out.println(5);
					}
				}
			}
			// N을 6으로 나눈 나머지가 3이면 짝수리스트에서 2를 가장 마지막으로 보내고 홀수리스트에서 1,3을 가장 마지막으로 보낸다.
			else if(N%6 ==3) {
				if(i*2<=N)
					if((i+1)*2>N) {
						System.out.println(2);
					}
					else {
						System.out.println((i+1)*2);						
					}
				else {
					if(i==N-1) {
						System.out.println(1);
					}
					if(i==N) {
						System.out.println(3);
					}
					if(i<N-1)
						System.out.println((i-N/2-1)*2+5);
				}
			}
		}
	}
}
