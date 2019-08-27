import java.util.*;

public class Main {
	static boolean[] chk = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		chk[0] = chk[1] = true;
		for(int i = 2; i * i < 100001; i++)
		{
			if(chk[i]) continue;
			for(int j = i + i; j < 100001; j+=i)
				chk[j] = true;
		}
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			int[] arr = new int[100001];
			Vector<Integer> v = new Vector<>();
			while(N > 1)
			{
				for(int i = 2; i < 100001; i++)
					if(N % i == 0)
					{
						N /= i;
						arr[i]++;
						if(!v.contains(i))
							v.add(i);
						break;
					}
			}
			
			for(int i : v)
				System.out.println(i + " " + arr[i]);
		}
	}
}