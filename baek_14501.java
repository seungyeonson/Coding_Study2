import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14501 {
	static int N, con[][], answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		con = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			con[i][0] = Integer.parseInt(st.nextToken());
			con[i][1] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		Consultant(0, 0, 0);
		System.out.println(answer);
	}
	static void Consultant(int i, int sum, int cnt) {
		if(i==N) {
			answer = Math.max(answer, sum);
			return;
		}
		if(cnt==0) {
			if(i+con[i][0]<=N)
				Consultant(i+1, sum+con[i][1], con[i][0]-1);
			Consultant(i+1, sum, cnt);
		}else if(cnt>0) {
			Consultant(i+1, sum, cnt-1);
		}
	}
}
