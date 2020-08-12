import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1991 {
	static class Node {
		Node left;
		Node right;
		int now;

		Node(int now) {
			this.now = now;
			left = null;
			right = null;
		}

		Node(int now, Node left, Node right) {
			this.now = now;
			this.left = left;
			this.right = right;
		}
	}
	static void preorder(Node n) {
		if(n==null) {
			
			return;
		}
		System.out.print((char)('A'+n.now));
		preorder(n.left);
		preorder(n.right);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		Node[] node = new Node[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			node[i] = new Node(st.nextToken().toCharArray()[0] - 'A', new Node(st.nextToken().toCharArray()[0] - 'A'),
					new Node(st.nextToken().toCharArray()[0] - 'A'));
		}
		preorder(node[0]);
	}
}
