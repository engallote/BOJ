import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static Vector<Integer> v = new Vector<>();
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int max = 0;
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			if(max < arr[i])
				max = arr[i];
		}
		
		while(true)
		{
			solve(max);
			max = 0;
			
			for(int i = 0; i < N; i++)
				if(max < arr[i])
					max = arr[i];
			
			if(max == 0)
				break;
		}
		
		v.sort(null);
		
		for(int i = 0; i < v.size(); i++)
			System.out.println(v.get(i)+1);
	}

	private static void solve(int max) {
		int idx = 0;
		for(int i = 0; i < N; i++)
		{
			if(max == arr[i])
			{
				idx = i;
				arr[idx] = -1;
				break;
			}
		}
		
		v.add(idx);
		int l = idx - 1, r = idx + 1, lMax = max, rMax = max;
		
		while(true)
		{
			if(l >= 0)
			{
				if(arr[l] < lMax && arr[l] != -1)
				{
					lMax = arr[l];
					arr[l] = -1;
					l--;
				}
				else
					break;
			}
			else
				break;
		}
		while(true)
		{
			if(r < N)
			{
				if(arr[r] < rMax && arr[r] != -1)
				{
					rMax = arr[r];
					arr[r] = -1;
					r++;
				}
				else
					break;
			}
			else
				break;
		}
	}
}