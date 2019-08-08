import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] empty = new boolean[51];
		ArrayList<Integer>[] arr = new ArrayList[N];
		for(int i = 0; i < N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		{
			int k = sc.nextInt();
			for(int j = 0; j < k; j++)
			{
				int num = sc.nextInt();
				arr[i].add(num);
			}
		}
		
		int M = sc.nextInt(), res = 0;
		boolean flag = true;
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			Arrays.fill(empty, false);
			res = 0;
			for(int j = 0; j < num; j++)
				empty[sc.nextInt()] = true;
			
			for(int k = 0; k < N; k++)
			{
				flag = true;
				for(int j : arr[k])
					if(!empty[j])
					{
						flag = false;
						break;
					}
				if(flag) res++;
			}
			System.out.println(res);
		}
	}
}