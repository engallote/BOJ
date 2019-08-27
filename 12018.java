import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int maxM = sc.nextInt();
		Vector<Integer> v = new Vector<>();
		
		for(int t = 0; t < tc; t++)
		{
			int P= sc.nextInt();
			int L = sc.nextInt();
			
			int[] arr = new int[P];
			
			for(int i = 0; i < P; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			if(P >= L)
				v.add(arr[P - L]);
			else
				v.add(1);
		}
		
		v.sort(null);
		
		int sum = 0, cnt = 0;
		for(int i = 0; i < v.size(); i++)
		{
			if(sum + v.get(i) <= maxM)
			{
				sum += v.get(i);
				cnt++;
			}
//			System.out.println(v.get(i));
		}
		System.out.println(cnt);
	}
}