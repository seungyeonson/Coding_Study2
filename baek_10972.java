import java.util.Arrays;
import java.util.Scanner;

public class baek_10972 {
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 마지막 숫자부터 시작해서 봉우리를 찾자.
		int i = N - 1;
		//
		while (i > 0 && arr[i] <= arr[i - 1])
			i--;
		// 만약 여기서 i==0이면 가장 처음 숫자가 제일 뒤의 숫자부터의 봉우리 이므로 다음 숫자가 없다.
		if (i == 0) {
			System.out.println(-1);
		} else {
			// 봉우리인 i와 그 이전 숫자인 i-1을 교환한다.
			//swap(arr, i - 1, i);
			
			//그다음에는 뒤의 숫자들을 정렬해야한다.
			//지금 현재 i에는 원래의 i-1이 있는데 이 숫자는 제일 뒤부터 탐색해서
			//이 숫자보다 처음으로 커지는 숫자와 교환한다.
			int j = N - 1;
			while (i < j && arr[i-1] >= arr[j]) {
				j--;
			}
			//만약 i,j가 같다면 이미 정렬되어있는것이다.

			swap(arr, i-1, j);
			
			//현재 i-1이 봉우리고 나머지는 앞에서부터 내림차순 정렬되어 있는 상태이다.
			//그 다음 숫자를 구하고 싶다면 이를 오름차순으로 바꾼다.
			// System.out.println(j);
			j = N-1;
			while (i < j) {
				swap(arr, i, j);
				i++;
				j--;
			}
			print(arr);
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
