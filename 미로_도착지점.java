package test;
import java.util.Scanner;
public class Solution1 {
	static int[] dr = {0, -1, 0, 1, 0};
	static int[] dc = {0, 0, 1, 0, -1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1;tc<=T;tc++) {
			int answer = 0;
			int N = sc.nextInt();
			int[][] map = new int[N+1][N+1];
			//map 초기화
			for(int i=0;i<N+1;i++) {
				for(int j=0;j<N+1;j++)
					map[i][j] = 0;
			}
			int[][] start = new int[1][2];
			for(int i=0;i<1;i++) {
				start[i][0] = sc.nextInt();
				start[i][1] = sc.nextInt();
			}
			int jumper = sc.nextInt();
			int[][] jumpers = new int[jumper][2];
			for (int i=0;i<jumper;i++) {
				jumpers[i][0] = sc.nextInt();
				jumpers[i][1] = sc.nextInt();
				map[jumpers[i][0]][jumpers[i][1]] = -1;
			}
			int jisi = sc.nextInt();
			int[][] jisis = new int[jisi][2];
			for(int i = 0;i<jisi;i++) {
				jisis[i][0] = sc.nextInt();
				jisis[i][1] = sc.nextInt();
			}
			///알고리즘 시작
			for(int i=0;i<jisi;i++) {
				for (int j=0;j<jisis[i][1];j++) {
					int x = dr[jisis[i][0]];
					int y = dc[jisis[i][0]];
					start[0][0] += x;
					start[0][1] += y;
					//System.out.println(start[0][0]+" "+start[0][1]);
					if ((start[0][0] < 1 || start[0][0] > N) || (start[0][1] < 1 || start[0][1] > N)) {
						start[0][0] = 0;
						start[0][1] = 0;
						break;
						}
					if (map[start[0][0]][start[0][1]] == -1){
						start[0][0] = 0;
						start[0][1] = 0;
						break;
						
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+start[0][0]+" "+start[0][1]);
		}
	}

}
