import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int[][] arr = new int[3][2];
		int[] pre = new int[3];
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < 3; i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			pre[i] = arr[i][1];
		}
		hs.add(arr[0][0]+":"+arr[0][1]+","+arr[1][0]+":"+arr[1][1]+","+arr[2][0]+":"+arr[2][1]);
		int cnt = 0, idx = 0, next = 0;
		String key = "";
		while(cnt < 100)
		{
//			for(int i = 0; i < 3; i++)
//				System.out.println("> " + arr[i][1]);
//			System.out.println("==================");
			next = (idx + 1) % 3;
			if(arr[idx][1] + arr[next][1] > arr[next][0])
			{
				int sub = arr[next][0] - arr[next][1];
				arr[idx][1] -= sub;
				arr[next][1] = arr[next][0];
			}
			else
			{
				arr[next][1] += arr[idx][1];
				arr[idx][1] = 0;
			}
			key = arr[0][0]+":"+arr[0][1]+","+arr[1][0]+":"+arr[1][1]+","+arr[2][0]+":"+arr[2][1];
			if(hs.contains(key)) break;
			for(int i = 0; i < 3; i++)
			{
//				System.out.println("> " + arr[i][1]);
				pre[i] = arr[i][1];
			}
//			System.out.println("----------");
			cnt++;
			idx = (idx + 1) % 3;
		}
		
		for(int i = 0; i < 3; i++)
			System.out.println(arr[i][1]);
	}
}