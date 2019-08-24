import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N+1];
		int[][] path = new int[M][3];
		Arrays.fill(arr, 1000000000);
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			path[i][0] = a;
			path[i][1] = b;
			path[i][2] = 1;
		}
		arr[1] = 0;
		boolean flag = true;
		Vector<Integer> v = new Vector<>();
		while(flag)
		{
			flag = false;
			for(int i = 0; i < M; i++)
			{
				if(arr[path[i][0]] + path[i][2] < arr[path[i][1]])
				{
					arr[path[i][1]] = arr[path[i][0]] + path[i][2];
					flag = true;
				}
				else if(arr[path[i][1]] + path[i][2] < arr[path[i][0]])
				{
					arr[path[i][0]] = arr[path[i][1]] + path[i][2];
					flag = true;
				}
			}
		}
		int max = 0;
		for(int i = 1; i <= N; i++)
		{
			if(max < arr[i])
			{
				v.clear();
				v.add(i);
				max = arr[i];
			}
			else if(max == arr[i])
			{
				v.add(i);
			}
		}
		v.sort(null);
		System.out.println(v.get(0) + " " + max + " " + v.size());
	}
}