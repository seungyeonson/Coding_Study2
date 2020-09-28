import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1991 {
	static Node[] nodes;
	static int N;
	static class Node {
		char parent;
		char left;
		char right;

		Node(char parent, char left, char right) {
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			char n = st.nextToken().toCharArray()[0];
			nodes[n-65] = new Node(n, st.nextToken().toCharArray()[0],
					st.nextToken().toCharArray()[0]);
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}

	private static void postorder(int i) {
		if(i>=N) {
			return;
		}
		if(nodes[i].left!='.')
			postorder(nodes[i].left-65);
		if(nodes[i].right!='.')
			postorder(nodes[i].right-65);
		System.out.print(nodes[i].parent);

	}

	private static void inorder(int i) {
		if(i>=N ) {
			return;
		}
		if(nodes[i].left!='.')
			inorder(nodes[i].left-65);
		System.out.print(nodes[i].parent);
		if(nodes[i].right!='.')
			inorder(nodes[i].right-65);

	}
//	 || nodes[i].left=='.'||nodes[i].right=='.'
	private static void preorder(int i) {
		if(i>=N) {
			return;
		}
		System.out.print(nodes[i].parent);
		if(nodes[i].left!='.')
			preorder(nodes[i].left-65);
		if(nodes[i].right!='.')
			preorder(nodes[i].right-65);

	}
}
