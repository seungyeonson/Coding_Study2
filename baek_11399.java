package finish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 ATM 11399
//설계 : 먼저 순서에 따른 값을 계산하는 함수, 순서를 섞는 함수, 시간복잡도가 들어간다면 최소보다 높으면 패쓰
//잘못설계했다...그리디로 하자
public class baek_11399 {
	static int N, arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		int t = 0;
		for(int i=0;i<N;i++) {
			sum+=arr[i]+t;
			t+=arr[i];
		}
		System.out.println(sum);
	}

}
