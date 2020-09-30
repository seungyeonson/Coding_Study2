import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class baek_2668 {
	static int N, arr[], last;
	static ArrayList<Integer> list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N + 1];
		visited = new boolean[N+1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			last = i;
			dfs(i);
			visited[i] = false;
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}

	}

	private static void dfs(int idx) {
		if (!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			dfs(arr[idx]);
			visited[arr[idx]] = false;
		}
		if (arr[idx] == last) {
			list.add(last);
		}
	}
}
