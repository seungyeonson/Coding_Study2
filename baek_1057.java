import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//토너먼트
public class baek_1057 {
	static class player implements Comparable<player>{
		int order;
		int number;
		player(int number){
			order = number;
			this.number = number;
		}
		@Override
		public int compareTo(player o) {
			
			return Integer.compare(this.order, o.order);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<player> list = new ArrayList<>();
		int answer = -1;
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			list.add(new player(i));
		}
		out :while(list.size()>1) {
			cnt++;
			Collections.sort(list);
			int total = list.size();
			if(total%2==0) {
				for(int i=total-1;i>=0;i = i-2) {
					player player1 = list.remove(i);
					player player2 = list.remove(i-1);
					if(player1.number==k && player2.number==m||player1.number==m && player2.number==k) {
						answer = cnt;
						break out;
					}else if(player1.number==k||player1.number==m) {
						list.add(player1);
					}else if(player2.number==k||player2.number==m) {
						list.add(player2);
					}else {
						list.add(player1);
					}
				}
			}else {
				for(int i=total-2;i>=0;i=i-2) {
					player player1 = list.remove(i);
					player player2 = list.remove(i-1);
					if(player1.number==k && player2.number==m||player1.number==m && player2.number==k) {
						answer = cnt;
						break out;
					}else if(player1.number==k||player1.number==m) {
						list.add(player1);
					}else if(player2.number==k||player2.number==m) {
						list.add(player2);
					}else {
						list.add(player1);
					}
				}
			}
		}
		System.out.println(answer);
		
	}
}
