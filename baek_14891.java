import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14891 {
	static List<Integer> queue[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		queue = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			queue[i] = new ArrayList<>();
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				queue[i].add(temp[j] - '0');
			}
		}
		int K = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int tire = Integer.parseInt(st.nextToken());
			int direct = Integer.parseInt(st.nextToken());
			turn(tire, direct);
		}
		System.out.println(getScore());

	}

	static void turn(int tire, int direct) {
		int list1_2 = queue[0].get(2);
		int list1_6 = queue[0].get(6);
		int list2_2 = queue[1].get(2);
		int list2_6 = queue[1].get(6);
		int list3_2 = queue[2].get(2);
		int list3_6 = queue[2].get(6);
		int list4_2 = queue[3].get(2);
		int list4_6 = queue[3].get(6);
		// 1번타이어를 회전하면 1-2-3-4순으로 회전
		if (tire == 1) {
			// 1번과 2번이 다른 극일 때는 반대반향으로 회전
			turnD(1, direct);
			if (list1_2 != list2_6) {
				turnD(2, direct * -1);
				if (list2_2 != list3_6) {
					turnD(3, direct);
					if (list3_2 != list4_6) {
						turnD(4, direct * -1);
					}
				}
			}
		}
		// 2번 타이어를 회전하면 1번과 3번을 동시에 회전시키고 그다음 4번 회전
		else if (tire == 2) {
			turnD(2, direct);
			// 1번과2번이 다른 극일때 회전
			if (list1_2 != list2_6) {
				turnD(1, direct * -1);
			}
			if (list2_2 != list3_6) {
				turnD(3, direct * -1);
				if (list3_2 != list4_6) {
					turnD(4, direct);
				}
			}
		}
		// 3번 타이어 회전하면 2번과 4번 동시에 회전시키고 그다음 1번 회전
		else if (tire == 3) {
			turnD(3, direct);
			// 1번과2번이 다른 극일때 회전
			if (list3_2 != list4_6) {
				turnD(4, direct * -1);
			}
			if (list2_2 != list3_6) {
				turnD(2, direct * -1);
				if (list1_2 != list2_6) {
					turnD(1, direct);
				}
			}
		}
		// 4번 타이어를 회전시키면 4-3-2-1 순으로 회전
		else if (tire == 4) {

			turnD(4, direct);
			if (list3_2 != list4_6) {
				turnD(3, direct * -1);
				if (list2_2 != list3_6) {
					turnD(2, direct);
					if (list1_2 != list2_6) {
						turnD(1, direct * -1);
					}
				}
			}
		}

	}

	static void turnD(int idx, int direct) {
		if (direct == 1) {
			int last = queue[idx - 1].get(7);
			queue[idx - 1].remove(7);
			queue[idx - 1].add(0, last);
		} else if (direct == -1) {
			int first = queue[idx - 1].get(0);
			queue[idx - 1].remove(0);
			queue[idx - 1].add(first);
		}
	}

	static int getScore() {
		int cnt = 0;
		int[] score = { 1, 2, 4, 8 };
		for (int i = 0; i < 4; i++) {
			cnt += queue[i].get(0) * score[i];
		}
		return cnt;
	}
}
