package IM;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class baek_2304 {
	static class Node implements Comparable<Node> {
		int a;
		int b;

		Node(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.b, this.b);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int N = sc.nextInt();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int L = sc.nextInt();
			int H = sc.nextInt();
			queue.add(new Node(L, H));
		}
		Node start = queue.poll();
		int s = start.a;
		int e = start.a;
		answer+=start.b;
		while(!queue.isEmpty()) {
			Node now  = queue.poll();
			if(now.a>e) {
				answer+=now.b*(now.a-e);
				e = now.a;
			}else if (now.a<s) {
				answer+=now.b*(s-now.a);
				s = now.a;
			}
		}
		System.out.println(answer);
	}
}
