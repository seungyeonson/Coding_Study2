import java.util.Scanner;

public class Nqeens_9663 {
	static int N, answer;
	static int[] col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		setQueens(1);

		System.out.println(answer);
	}

	public static void setQueens(int rowNo) {

		if (rowNo > N) {
			answer++;
			for (int i = 1; i < N + 1; i++) {
				System.out.println(col[i]);
			}
			System.out.println();
			System.exit(0);
			return;
		}
		for (int j = 1; j <= N; j++) {
			col[rowNo] = j;
			if (checking(rowNo))
				setQueens(rowNo + 1);
		}
	}

	private static boolean checking(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if ((col[rowNo] == col[i]) || Math.abs(col[rowNo] - col[i]) == rowNo - i)
				return false;
		}
		return true;
	}
}
