import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int P = sc.nextInt();
		int[][] arr = new int[N+1][T];
		int[] m = new int[T], number = new int[N+1];
		for(int i = 1; i <= N; i++)
		{
			for(int j = 0; j < T; j++)
			{
				arr[i][j] = sc.nextInt();
				m[j] += arr[i][j];
				number[i] += arr[i][j];
			}
		}
		Pair[] sort = new Pair[N];
		for(int i = 1; i <= N; i++)
		{
			sort[i-1] = new Pair(i, 0, number[i]);
			
			for(int j = 0; j < T; j++)
			{
//				if(i == 1) System.out.println(j + " > " + (N - m[j]));
				if(arr[i][j] == 1)
					sort[i-1].rate += (N - m[j]);
			}
		}
		
		Arrays.sort(sort);
		int cnt = 1, res = 0;
		for(Pair p : sort)
		{
//			System.out.println(p.idx + " " + p.rate + " " + p.num);
			res = p.rate;
			if(p.idx == P) break;
			cnt++;
		}
		System.out.println(res + " " + cnt);
		
	}
}
class Pair implements Comparable<Pair>{
	int idx, rate, num;
	Pair(int idx, int rate, int num)
	{
		this.idx = idx;
		this.rate = rate;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.rate > this.rate) return 1;
		else if(o.rate == this.rate)
		{
			if(o.num > this.num) return 1;
			else if(o.num == this.num)
			{
				if(o.idx > this.idx) return -1;
				else return 1;
			}
			else return -1;
		}
		else return -1;
	}
}