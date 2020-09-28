import java.util.ArrayList;
import java.util.Scanner;

public class baek_11725 {
	static Node[] nodes;
	static boolean[] visited;
	static class Node {
		int level;
		ArrayList<Integer> child;

		Node() {
			level = -1;
			child = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		nodes = new Node[N + 1];
		visited = new boolean[N+1];
		for (int i = 0; i < N + 1; i++) {
			nodes[i] = new Node();
		}
		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			nodes[from].child.add(to);
			nodes[to].child.add(from);
		}
		nodes[1].level = 0;
		visited[1] = true;
		getLevel(1);
		for (int i = 2; i < N + 1; i++) {
			System.out.println(getParent(i));
		}

	}

	private static int getParent(int idx) {
		int nodes_num = 0;
		for (int i = 0; i < nodes[idx].child.size(); i++) {
			if(nodes[idx].level -1 == nodes[nodes[idx].child.get(i)].level) {
				nodes_num = nodes[idx].child.get(i);
				break;
			}
		}
		return nodes_num;
	}

	private static void getLevel(int idx) {
		if (nodes[idx].child.size() == 0) {
			return;
		}
		for (int i = 0; i < nodes[idx].child.size(); i++) {
			if (nodes[nodes[idx].child.get(i)].level == -1 &&!visited[nodes[idx].child.get(i)]) {
				nodes[nodes[idx].child.get(i)].level = nodes[idx].level + 1;
				visited[nodes[idx].child.get(i)] = true;
				getLevel(nodes[idx].child.get(i));
			}
		}
	}
}
