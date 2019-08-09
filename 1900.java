import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int[] win = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				if(i != j)
				{
					int power1 = arr[i][0] + (arr[i][1] * arr[j][0]);
					int power2 = arr[j][0] + (arr[j][1] * arr[i][0]);
					
					if(power1 > power2)
						win[i]++;
					else
						win[j]++;
				}
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			pq.add(new Pair(i+1, win[i]));
		
		while(!pq.isEmpty())
			System.out.println(pq.poll().num);
	}
}
class Pair implements Comparable<Pair>{
	int win, num;
	Pair(int num, int win)
	{
		this.num = num;
		this.win = win;
	}
	@Override
	public int compareTo(Pair o) {
		return o.win > this.win ? 1 : -1;
	}
}