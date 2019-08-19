import java.util.*;

public class Main {
	static int res = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
		{
			int s = sc.nextInt();
			int e = sc.nextInt();
			arr[i] = new Pair(s, e);
		}
		
		Arrays.sort(arr);
		
		int start = arr[0].e - arr[0].s;
		boolean flag = false;
		while(start >= 0)
		{
			flag = true;
			int time = start + arr[0].s;
			
			for(int i = 1; i < N; i++)
			{
				if(time + arr[i].s <= arr[i].e)
					time += arr[i].s;
				else
				{
					flag = false;
					break;
				}
			}
			if(flag) break;
			start--;
		}
		if(start < 0) start = -1;
		System.out.println(start);
	}
}
class Pair implements Comparable<Pair>{
	int s, e;
	Pair(int s, int e)
	{
		this.s = s;
		this.e = e;
	}
	@Override
	public int compareTo(Pair o) {
		return o.e > this.e ? -1 : 1;
	}
}