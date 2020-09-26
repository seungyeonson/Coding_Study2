package IM;

import java.util.Scanner;

public class baek_13300 {
	static int[][] student;

	public static void main(String[] args) {
		student = new int[6][2];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int boy = sc.nextInt();
			int grade = sc.nextInt();
			student[grade-1][boy]++;
		}
		for(int i=0;i<6;i++)
			answer += (int)(Math.ceil((double)student[i][0]/K)+Math.ceil((double)student[i][1]/K));
		System.out.println(answer);
	}
}
