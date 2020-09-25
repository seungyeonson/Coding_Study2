package IM;

import java.util.Scanner;

/*
3 10 50 60 100 100 200 300
45 50 600 600 400 450 500 543
11 120 120 230 50 40 60 440
35 56 67 90 67 80 500 600
 */

public class baek_2527 {
	static class Rect {
		int a;
		int b;
		int c;
		int d;

		Rect(int a, int b, int c, int d) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char answer = 'a';
		for (int tc = 0; tc < 4; tc++) {
			Rect a = new Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			Rect b = new Rect(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			// 공통부분이 없는경우
			if ((a.c < b.a || a.d < b.b) || (b.c < a.a || b.d < a.b)) {
				answer = 'd';
			}
			
			//점
			else if((a.c==b.a &&a.b == b.d)||(a.c==b.a && a.d==b.b)||(a.a==b.c && a.d ==b.b) || (a.a==b.c&&a.b==b.d) ) {
				answer = 'c';
			}
			//선분
			else if(a.b == b.d || a.c == b.a || a.d == b.b || a.a == b.c) {
				answer = 'b';
			}else {
				answer = 'a';
			}
			//
			System.out.println(answer);
		}

	}
}
