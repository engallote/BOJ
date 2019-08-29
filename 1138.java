import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		Vector<Integer> v = new Vector<>();
		
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		for(int i = N; i > 0; i--)
		{
			if(arr[i] == 0)
			{
				boolean f = true;
				for(int j = 0; j < v.size(); j++)
					if(v.get(j) > i)
					{
						f = false;
						break;
					}
				if(f)
					v.add(i);
				else
					v.insertElementAt(i, 0);
			}
			else
			{
				int num = arr[i], cnt = 0;
				for(int j = 0; j < v.size(); j++)
					if(v.get(j) > i)
					{
						cnt++;
						if(cnt == num)
							v.insertElementAt(i, j+1);
					}
			}
		}
		
		for(int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " ");
	}
}