import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] chk = new boolean[1001];
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 2; i <= 1000; i++)
		{
			if(chk[i]) continue;
			arr.add(i);
			for(int j = i + i; j <= 1000; j+=i) chk[j] = true;
		}
		int len = arr.size();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			boolean flag = false;
			
			for(int i = 0; i < len; i++)
			{
				for(int j = i; j < len; j++)
				{
					for(int k = j; k < len; k++)
						if(arr.get(i) + arr.get(j) + arr.get(k) == N)
						{
							System.out.println(arr.get(i) + " " + arr.get(j) + " " + arr.get(k));
							flag = true;
							break;
						}
					if(flag) break;
				}
				if(flag) break;
			}
			
			if(!flag) System.out.println(0);
		}
	}
}