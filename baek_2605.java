package IM;

import java.util.ArrayList;
import java.util.Scanner;

//백준 2605 줄 세우기
public class baek_2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		ArrayList<Integer> student = new ArrayList<>();
		for(int i=0;i<N;i++) {
			int temp = sc.nextInt();
			student.add(i-temp, i+1);
		}
		for(int i=0;i<N;i++) {
			System.out.print(student.get(i)+" ");
		}
	}
}
