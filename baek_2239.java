import java.util.Scanner;

public class baek_2239 {
	static char[][] map = new char[9][9];
	static boolean isFinished;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			map[i] = sc.next().toCharArray();
		dfs(0, 0);
		System.out.println(ans);
	}
	static String ans = "";
	static void dfs(int r, int c) {
		if(isFinished)
			return;
		if(r == 9 && c == 0) {
			isFinished = true;
			for(int i = 0; i < 9; i++) {
				ans += new String(map[i]) + "\n";
			}
			return;
		}
		if( map[r][c] == '0' ) {
			//1���� 9���� ���� �߿���, ��.��.�ڽ��� ������� ���� ���ڵ��� �ְ� �������� ����.
			for(int num = 1; num < 10; num++) {
				if( check(r, c, (char)(num+48))) {
					char tmp = map[r][c];
					map[r][c] = (char)(num+48);
					//�� �� ĭ�̸� �����ٷ� �̵�	
					if(c == 8) 
						dfs(r+1, 0);
					//�ƴϸ� �׳� ����ĭ���� �̵�
					else
						dfs(r, c+1);
					map[r][c] = tmp;
				}
			}
		}
		//���� �ڸ��� 0�� �ƴ� ���� ���� ĭ���� �̵�
		else {
			//�� �� ĭ�̸� �����ٷ� �̵�	
			if(c == 8) 
				dfs(r+1, 0);
			//�ƴϸ� �׳� ����ĭ���� �̵�
			else
				dfs(r, c+1);
		}
	}
	//r,c�ڸ��� val���ڰ� ���� �Ǵ��� �˻�.
	static boolean check(int r, int c, char val) {
		//���̶� ���� ���� ���� �ִ��� �˻�
		for(int i = 0; i < 9; i++) {
			if(map[r][i] == val)
				return false;
			if(map[i][c] == val)
				return false;
		}
		//�ڽ��˻�
		int bSr = r / 3 * 3;
		int bSc = c / 3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(map[bSr + i][bSc + j] == val)
					return false;
			}
		}
		return true;
	}
}






