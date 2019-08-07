import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			long N = sc.nextLong();
			boolean flag = false;
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 2; i <= 64; i++)
			{
				long num = N;
				arr.clear();
				while(num > 0)
				{
					arr.add((int)(num % i));
					num /= i;
				}
				
				int l = 0, r = arr.size() - 1;
				while(l <= r)
				{
					if(arr.get(l) != arr.get(r)) break;
					l++;
					r--;
				}
				if(l >= r) 
				{
					flag = true;
					break;
				}
			}
			System.out.println(flag ? 1 : 0);
		}
	}
}