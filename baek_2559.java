package IM;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2559 {
	static int N, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		int answer = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < R; i++) {
			int A = sc.nextInt();
			queue.add(A);
			temp += A;
		}
		//System.out.println(temp);
		answer = Math.max(answer, temp);
		for (int i = R; i < N; i++) {
			int minus = queue.poll();
			int A = sc.nextInt();
			queue.add(A);
			temp -= minus;
			temp += A;
			//System.out.println(temp);
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
	}
}
