import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1001];
		int maxLen = 0, minLen = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			arr[x] = sc.nextInt();
			maxLen = Math.max(maxLen, x);
			minLen = Math.min(minLen, x);
		}
		
		int[] leftMax = new int[1001], rightMax = new int[1001];
		for(int i = minLen; i <= maxLen; i++)
		{
			if(i == 0)
				leftMax[i] = arr[i];
			else
				leftMax[i] = Math.max(arr[i], leftMax[i-1]);				
		}
		
		for(int i = maxLen; i >= minLen; i--)
		{
			if(i == maxLen) rightMax[i] = arr[i];
			else
				rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		}
		
		boolean change = false;
		int sum = 0;
		for(int i = minLen; i <= maxLen; i++)
		{
			if(!change && leftMax[i] == rightMax[i])
			{
//				System.out.println(leftMax[i]);
				change = true;
				sum += leftMax[i];
			}
			else if(!change)
			{
//				System.out.println(leftMax[i]);
				sum += leftMax[i];
			}
			else
			{
//				System.out.println(rightMax[i]);
				sum += rightMax[i];
			}
		}
		System.out.println(sum);
	}
}