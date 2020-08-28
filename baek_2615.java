import java.io.IOException;
import java.util.Scanner;

public class baek_2615 {
   static int[][] map;
   static boolean end;
   static int ei, ej;

   public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);

      map = new int[19][19];

      for (int i = 0; i < 19; i++) {
         for (int j = 0; j < 19; j++) {
            map[i][j] = sc.nextInt();
         }
      }

      for (int i = 0; i < 19; i++) {
         for (int j = 0; j < 19; j++) {
            if (map[i][j] != 0) {
               check(i, j, map[i][j]);
               if (end) {
                  System.out.println(map[i][j]);
                  System.out.println((i + 1) + " " + (j + 1));
                  System.exit(0);
               }
               // end = false;
            }
         }
      }

      System.out.println(0);
   }

   private static void check(int i, int j, int k) {
      boolean chk;
      int cr = i;
      int cc = j;
      int cnt = 1;

      // 우측검사
      while (true) {
         if (cc + 1 < 19 && map[i][cc + 1] == k ) {
            cc += 1;
            cnt++;
         } else
            break;
      }
      chk = true;
      if (cnt == 5) {
         if (j - 1 >= 0 && map[i][j - 1] == k) {
            chk = false;
         }
         if (chk) {
            end = true;
            ei = i;
            ej = j;
            return;
         }
      }

      // 아래검사
      cr = i;
      cc = j;
      cnt = 1;
      while (true) {
         if (cr + 1 < 19 && map[cr + 1][j] == k) {
            cr += 1;
            cnt++;
         } else
            break;
      }
      chk = true;
      if (cnt == 5) {
         if (i - 1 >= 0 && map[i - 1][j] == k) {
            chk = false;
         }
         if (chk) {
            end = true;
            ei = i;
            ej = j;
            return;
         }
      }

      // 오른쪽 아래 검사
      cr = i;
      cc = j;
      cnt = 1;
      while (true) {
         if (cr + 1 < 19 && cc + 1 < 19 && map[cr + 1][cc + 1] == k) {
            cr += 1;
            cc += 1;
            cnt++;
         } else
            break;
      }
      chk = true;
      if (cnt == 5) {
         if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == k)
            chk = false;
         if (chk) {
            end = true;
            ei = i;
            ej = j;
            return;
         }
      }

      // 오른쪽 윗
      cr = i;
      cc = j;
      cnt = 1;
      while (true) {
         if (cr - 1 >= 0 && cc + 1 < 19 && map[cr - 1][cc + 1] == k) {
            cr -= 1;
            cc += 1;
            cnt++;
         } else
            break;
      }
      chk = true;
      if (cnt == 5) {
         if (i + 1 < 19 && j - 1 >= 0 && map[i + 1][j - 1] == k)
            chk = false;
         if (chk) {
            end = true;
            ei = i;
            ej = j;
            return;
         }
      }
   }
}