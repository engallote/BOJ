import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dice = new int[3];
		int[] arr = new int[7];
		int max = 0;
		for(int i = 0; i < N; i++)
		{
			int sum = 0, num = 0, tmpMax = 0;
			dice[0] = sc.nextInt();
			dice[1] = sc.nextInt();
			dice[2] = sc.nextInt();
			Arrays.sort(dice);
			Arrays.fill(arr, 0);
			int a = dice[0], b = dice[1], c = dice[2];
			arr[a]++;
			if(tmpMax < arr[a])
			{
				tmpMax = arr[a];
				num = a;
			}
			arr[b]++;
			if(tmpMax <= arr[b])
			{
				tmpMax = arr[b];
				num = b;
			}
			arr[c]++;
			if(tmpMax <= arr[c])
			{
				tmpMax = arr[c];
				num = c;
			}
			if(tmpMax == 1)
				sum = num * 100;
			else if(tmpMax == 2)
				sum = 1000 + num * 100;
			else
				sum = 10000 + num * 1000;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}