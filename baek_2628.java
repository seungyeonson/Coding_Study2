package IM;

import java.util.Arrays;
import java.util.Scanner;

public class baek_2628 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt();
		int answer = 0;
		int[] width = new int[W];
		int[] height = new int[H];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (x == 0) {
				for (int j = 0; j < y; j++) {
					width[j] += 1;
				}

			} else {
				for (int j = 0; j < y; j++) {
					height[j] += 1;
				}

			}

		}
		int max_a = 0, max_b = 0;

		int[] A = new int[100];
		int[] B = new int[100];
		for (int i = 0; i < width.length; i++) {
			A[width[i]]++;
		}
		for (int i = 0; i < height.length; i++) {
			B[height[i]]++;
		}
		for (int i = 0; i < A.length; i++) {
			max_a = Math.max(max_a, A[i]);
			max_b = Math.max(max_b, B[i]);
		}
		System.out.println(max_a * max_b);
	}
}
