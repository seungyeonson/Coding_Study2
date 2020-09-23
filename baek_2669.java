package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2669 {
	static boolean[][] square;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		square = new boolean[100][100];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int nx = Integer.parseInt(st.nextToken()) - 1;
			int ny = Integer.parseInt(st.nextToken()) - 1;
			int mx = Integer.parseInt(st.nextToken()) - 1;
			int my = Integer.parseInt(st.nextToken()) - 1;
			for (int j = nx; j < mx; j++) {
				for (int k = ny; k < my; k++) {
					square[j][k] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (square[i][j])
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
