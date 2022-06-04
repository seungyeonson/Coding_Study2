import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*w-abs(w-mod(p+t,2*w)
 * 6 4
 * 4 1 => 12 9 => 12%8 9%12 => 6-4 4-9 
 * 8
 * 
 * 0 1
 * 
 * 6 4
 * 5 3 => 9 7 => 9%8 7%12 1 7
 * 4
 * 
 * 3 1
 * */
public class baek_10158 {
	static int w, h, p, q, t;
	static int x = 1, y = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 직사각형 크기
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 초기 위치
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 시간
		t = Integer.parseInt(st.nextToken());
		p = w-Math.abs(w-(p+t)%(2*w));
		q = h-Math.abs(h-(q+t)%(2*h));

		System.out.println(p + " " + q);

	}

}
