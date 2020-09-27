import java.util.ArrayList;
import java.util.Scanner;

public class baek_1068 {
	static Node[] nodes;
	static int N, answer, R;

	static class Node {
		int parent;
		ArrayList<Integer> child;

		Node(int parent) {
			this.parent = parent;
			child = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
		R = sc.nextInt();
		int start = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == -1) {
				start = i;
				continue;
			}
			nodes[arr[i]].child.add(i);
		}
		answer = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == -1 && i != R) {
				countLeafNode(i);
			}
		}
		System.out.println(answer);
	}

	public static void countLeafNode(int start) {

		if (nodes[start].child.size() == 0) {
			answer++;
		}
		for (int i = 0; i < nodes[start].child.size(); i++) {
			if (nodes[start].child.get(i) == R) {
				if(nodes[start].child.size()==1) {
					answer++;
				}
				continue;
			}
			countLeafNode(nodes[start].child.get(i));
		}
	}
}
