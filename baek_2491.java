package IM;

import java.util.ArrayList;
import java.util.Scanner;
//수열
public class baek_2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> inc = new ArrayList<>();
		ArrayList<Integer> dec = new ArrayList<>();
		inc.add(arr[0]);
		dec.add(arr[0]);
		int answer = 0;
		for(int i=0;i<N-1;i++) {
			if(arr[i]<=arr[i+1] ) {
				inc.add(arr[i+1]);
				if(arr[i]<arr[i+1]) {
					answer = Math.max(answer, dec.size());
					dec = new ArrayList<>();
					dec.add(arr[i+1]);
				}
			}
			if(arr[i]>=arr[i+1]) {
				dec.add(arr[i+1]);
				if(arr[i]>arr[i+1]) {
					answer = Math.max(answer, inc.size());
					inc = new ArrayList<>();
					inc.add(arr[i+1]);
				}
			}
		}
		answer = Math.max(answer, Math.max(inc.size(), dec.size()));
		System.out.println(answer);
		
	}
}
