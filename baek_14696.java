package IM;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14696 {
	static int[][] contest;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		char answer = 'D';
		for (int i = 0; i < N; i++) {
			contest = new int[6][2];
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			for(int k=0;k<A;k++) {
				int temp = Integer.parseInt(st.nextToken());
				contest[temp][0]++;
			}
			st = new StringTokenizer(in.readLine());
			int B = Integer.parseInt(st.nextToken());
			for(int k=0;k<B;k++) {
				int temp = Integer.parseInt(st.nextToken());
				contest[temp][1]++;
			}
			for (int j = 5; j > 0; j--) {
                answer = 'D';
				if(contest[j][0]>contest[j][1]) {
					answer = 'A';
					break;
				}else if(contest[j][0]<contest[j][1]) {
					answer = 'B';
					break;
				}
			}
			System.out.println(answer);

		}
	}
}
