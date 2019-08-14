import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		boolean flag = true;
		Arrays.fill(arr, -1);
		
		for(int i = 1; i <= N; i++)
		{
			String num = sc.next();
			if(!num.equals("mumble"))//¿õ¾ó°Å¸²
				arr[i] = Integer.parseInt(num);
		}
		
		for(int i = 1; i <= N; i++)
		{
			if(arr[i] == -1) continue;
			if(arr[i] != i)
			{
				flag = false;
				break;
			}
		}
		
		System.out.println(flag ? "makes sense" : "something is fishy");
	}
}