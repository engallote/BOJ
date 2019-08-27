import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Vector<Integer> v = new Vector<>();
		
		for(int i = 0; i < N; i++)
		{
			int start = sc.nextInt();
			int dis = sc.nextInt();
			int num = sc.nextInt();
			if(!v.contains(start))
				v.add(start);
			for(int j = 0; j < num-1; j++)
			{
				start += dis;
				if(!v.contains(start))
					v.add(start);
			}
		}
		
		v.sort(null);
		
		if(v.get(v.size() - 1) < M)
		{
			System.out.println(-1);
			return;
		}

		int min = 1000000000;
		for(int i = 0; i < v.size(); i++)
			if(v.get(i) - M >= 0)
			{
				if(min > v.get(i) - M)
					min = v.get(i) - M;
				else
					break;
			}
		if(min != 1000000000)
			System.out.println(min);
		else
			System.out.println(-1);
	}
}