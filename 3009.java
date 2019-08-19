import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hs = new HashMap<>();
		int[] left = new int[1001], right = new int[1001];
		for(int i = 0; i < 3; i++)
		{
			int a = sc.nextInt();
			left[a]++;
			int b = sc.nextInt();
			right[b]++;
		}
		int l = 0, r = 0;
		for(int i = 0; i <= 1000; i++)
			if(left[i] % 2 != 0)
			{
				l = i;
				break;
			}
		for(int i = 0; i <= 1000; i++)
			if(right[i] % 2 != 0)
			{
				r = i;
				break;
			}
		System.out.println(l + " " + r);
	}
}