package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//빙고
public class baek_2578 {
	static int N = 5;
	static boolean[][] go;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] bingo = new int[N][N];
		int[] S = new int[N*N];
		go = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for (int j=0;j<N;j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				S[N*i+j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N*N;i++) {
			out:for(int d=0;d<N;d++) {
				for(int k=0;k<N;k++) {
					if(bingo[d][k] == S[i]) {
						go[d][k] = true;
						break out;
					}
				}
			}
			if(check(go)) {
				System.out.println(i+1);
				break;
			}
		}
		//System.out.println(Arrays.toString(S));
		
	}
	private static boolean check(boolean[][] bingo) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			//가로 확인
			if(go[i][0]) {
				boolean flag = false;
				for(int j=0;j<N;j++) {
					if(go[i][j]) {
						flag = true;
						continue;
					}else {
						flag = false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			//세로 확인
			if(go[0][i]) {
				boolean flag = false;
				for(int j=0;j<N;j++) {
					if(go[j][i]) {
						flag = true;
						continue;
					}else {
						flag = false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
		}
		//대각선 확인
		if(go[0][0]) {
			boolean flag = false;
			for(int j=0;j<N;j++) {
				if(go[j][j]) {
					flag = true;
					continue;
				}else {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		if(go[N-1][0]) {
			boolean flag = false;
			for(int j=0;j<N;j++) {
				if(go[j][N-j-1]) {
					flag = true;
					continue;
				}else {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		if(cnt>=3) {
			return true;
		}
		return false;
	}
}
