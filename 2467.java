import java.util.*;

public class Main {
	static int N, res = Integer.MAX_VALUE;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		int l = 0, r = N - 1;
		int idx1 = 0, idx2 = 0;
		while(l < r)
		{
			int num = arr[l] + arr[r];
			
			if(num < 0)
			{
				if(res > Math.abs(num))
				{
					res = Math.abs(num);
					idx1 = l;
					idx2 = r;
				}
				l++;
			}
			else if(num > 0)
			{
				if(res > num)
				{
					res = num;
					idx1 = l;
					idx2 = r;
				}
				r--;
			}
			else 
			{
				idx1 = l;
				idx2 = r;
				break;
			}
		}
		System.out.println(arr[idx1] + " " + arr[idx2]);
	}
}