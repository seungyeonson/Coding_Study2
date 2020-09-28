import java.util.ArrayList;
import java.util.Scanner;

public class baek_9934 {
	static int[] arr;
	static int K,N;
	static ArrayList<Integer>[] answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = (int)Math.pow(2, K)-1;
		arr = new int[N];
		answer = new ArrayList[K];
		for(int i=0;i<K;i++) {
			answer[i] = new ArrayList<>();
		}
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}

		printLevel(0,N,0);
		for(int i=0;i<K;i++) {
			for(int j=0;j<answer[i].size();j++) {
				System.out.print(answer[i].get(j)+" ");
			}
			System.out.println();
		}
	}

	private static void printLevel(int start, int end, int i) {
		if(i==K) {
			return;
		}
		answer[i].add(arr[(start+end)/2]);
		printLevel(start,(start+end)/2-1,i+1);
		printLevel((start+end)/2+1,end,i+1);
		
	}
}
