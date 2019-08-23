import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] tab = new int[N];
		int[] order = new int[K];

		for(int i = 0; i < K; i++)
			order[i] = sc.nextInt();
		
		int cnt = 0;
		for(int i = 0; i < K; i++)
		{
			boolean use = false;
			for(int j = 0; j < N; j++)
				if(tab[j] == order[i])
				{
					use = true;
					break;
				}
			
			if(use) continue;
			
			for(int j = 0; j < N; j++)
				if(tab[j] == 0)
				{
					tab[j] = order[i];
					use = true;
					break;
				}
			
			if(use) continue;
			
			int idx = 0, max = 0;
			for(int j = 0; j < N; j++)
			{
				int miss = 0;
				for(int k = i + 1; k < K && tab[j] != order[k]; k++)
					miss++;
				if(miss > max)
				{
					max = miss;
					idx = j;
				}
			}
			
			tab[idx] = order[i];
			cnt++;
		}
		
		System.out.println(cnt);
	}
}