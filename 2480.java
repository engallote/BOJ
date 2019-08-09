import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dice = new int[3];
		dice[0] = sc.nextInt();
		dice[1] = sc.nextInt();
		dice[2] = sc.nextInt();
		
		Arrays.sort(dice);
		int a = dice[0], b = dice[1], c = dice[2];
		int[] arr = new int[7];
		int max = 0, num = 0;
		arr[a]++;
		if(max < arr[a])
		{
			max = arr[a];
			num = a;
		}
		arr[b]++;
		if(max <= arr[b])
		{
			max = arr[b];
			num = b;
		}
		arr[c]++;
		if(max <= arr[c])
		{
			max = arr[c];
			num = c;
		}
		
		if(max == 1)
			System.out.println(num*100);
		else if(max == 2)
			System.out.println(1000+num*100);
		else
			System.out.println(10000+num*1000);
	}
}