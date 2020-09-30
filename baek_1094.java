import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//막대기
public class baek_1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(64);
		int sum = 64;
		while(sum!=x) {
			Collections.sort(list);
			int min = list.remove(0);
			sum=0;
			list.add(min/2);
			for(int a:list) {
				sum+=a;
			}
			if(sum<x) {
				list.add(min/2);
			}
			
		}
		System.out.println(list.size());
	}
}
