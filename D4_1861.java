import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
public class D4_1861 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] arr;
	static int answer;

	static  int N, max;
	static Queue<Node> queue;
	static class Node{
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static void bfs(int cnt, int stx,int sty) {
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.peek().y;
			queue.poll();
			for(int i=0;i<4;i++) {
				int dx = x + dr[i];
				int dy = y + dc[i];
				if(0<=dx && dx<N && 0<=dy && dy<N) {
					if(arr[dx][dy]==arr[x][y]+1) {
						cnt++;
						queue.add(new Node(dx,dy));
					}
				}
			}
		}
//		System.out.println();
//		System.out.println("x,y"+stx+" "+sty);
//		System.out.println(arr[stx][sty]+" "+cnt);
		if(cnt>max) {
			max = cnt;
			answer = arr[stx][sty];
		}
		else if(cnt==max && arr[stx][sty]<answer) {
			answer = arr[stx][sty];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			answer = 0; // 방번호
			max = 0;//최대 이동거리
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			StringTokenizer st;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					queue = new LinkedList<>();
					queue.add(new Node(i,j));
					bfs(1,i,j);
				}
			}
			System.out.println("#"+tc+" "+answer+" "+max);
		}
	}
}
