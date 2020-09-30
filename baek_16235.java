import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_16235 {
	public static int N;
	public static int M;
	public static int K;
	public static int arr[];
	public static int nutriarea[];
	public static LinkedList<tree> trees[];
	public static LinkedList<tree> death[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N*N + 1];
		trees = new LinkedList[N*N + 1];
		death = new LinkedList[N*N + 1];
		nutriarea = new int[N*N + 1];
		
		for(int i = 1; i <= N ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N ; j ++)
			{
				arr[(((i-1)*N) + j)] = 5;
				nutriarea[(((i-1)*N) + j)] = Integer.parseInt(st.nextToken());
				trees[(((i-1)*N) + j)] = new LinkedList<>();
				death[(((i-1)*N) + j)] = new LinkedList<>();
			}
		}
        //2차원 배열이 아니라 1차원 배열로 해서 땅을 1 , 2 ,3 으로 번호 매김 
		for(int i = 0; i < M ; i ++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees[((x-1)*N) + y].add(new tree(age));
		}
		
		for(int i = 0; i < K ; i++)
		{
			//봄
			
			spring();
			
			//여름
			summer();
			
			//가을
			fall();
			
			//겨울
			winter();
			
		
			
		}

		int count = 0;
		for(int i = 1; i <= N*N; i ++)
		{
			if(!trees[i].isEmpty())
			{
				
				count += trees[i].size(); 
			}
		}
		System.out.println(count);
	
	}
	private static void winter() {
		for(int i = 1; i <= N*N ; i ++)
		{
			arr[i] = arr[i] + nutriarea[i];
		}
	}
	private static void fall() {
		int dx[] = {-(N+1),-1,(N-1),-N,N,-(N-1),1,(N+1)};
		for(int i = 1; i <= N*N; i ++)
		{
			if(!trees[i].isEmpty())
			{
				Iterator<tree> it = trees[i].iterator();
				while(it.hasNext())
				{
					tree t = it.next();
					
					int age = t.age;
					if(age%5 ==0)
					{
						int tx = 0;
						for(int k =0; k < 8; k ++)
						{
							tx = i + dx[k];
							if(tx <= 0 || tx > N*N) continue;
							if(i%N == 0)
							{
							
								if(k == 5 || k == 6 ||  k ==7) continue;
							}
							else if(i%N == 1)
							{
							
								if(k == 0 || k == 1 || k ==2)continue;
							}
							if (i == 1) {
								if (k == 3 || k == 5) {
									continue;
								}
							}
							if (i == (N - 1) * N + 1) {
								if (k == 4 || k == 7) {
									continue;
								}
							}
							trees[tx].addFirst(new tree(1));
						}
					}
				}
				/*for(int j = 0; j < trees[i].size(); j++)
				{
					int age = trees[i].get(j).age;
					if(age%5 ==0)
					{
						int tx = 0;
						for(int k =0; k < 8; k ++)
						{
							tx = i + dx[k];
							if(tx <= 0 || tx > N*N) continue;
							if(i%N == 0)
							{
							
								if(k == 5 || k == 6 ||  k ==7) continue;
							}
							else if(i%N == 1)
							{
							
								if(k == 0 || k == 1 || k ==2)continue;
							}
						
							trees[tx].addFirst(new tree(1));
						}
					}
				}*/
			}
		}
	}
	private static void summer() {
		for(int i = 1; i <= N*N; i ++)
		{
			if(!death[i].isEmpty())
			{
				Iterator<tree> it = death[i].iterator();
				while(it.hasNext())
				{
					tree t = it.next();
					int age =  t.age / 2;
					arr[i] = arr[i] + age;
					it.remove();
				}
			}
			death[i].clear();
		}
	}
	private static void spring() {
		for(int i = 1; i <= N*N; i ++)
		{
			if(!trees[i].isEmpty())
			{
				
				Iterator<tree> it = trees[i].iterator();
				while(it.hasNext())
				{
					tree t = it.next();
					int nutri = arr[i];
					int age = t.age;
					int tempnutri = nutri - age;
					if( tempnutri < 0)
					{
						death[i].add(t);
						it.remove();	
					}else
					{
						arr[i] = tempnutri; 
						t.age = age + 1;
					}
				}
			}
		}
	}
	public static class tree{

		int age;
		
		@Override
		public String toString() {
			return "tree [age=" + age + "]";
		}

		tree(int age)
		{
			this.age = age;
		}

		
	}
}