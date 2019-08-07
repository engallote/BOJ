import java.util.*;

public class Main {
	static boolean aWin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N], b = new int[N];
		for(int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		for(int i = 0; i < N; i++)
			b[i] = sc.nextInt();
		int max = 0, as = 0, bs = 0, cnt = 1;
		aWin = winA(a[0], b[0]);
		for(int i = 1; i < N; i++)
		{
			if(aWin)
			{
				if(winA(a[i], b[i])) cnt++;
				else
				{
					max = Math.max(max, cnt);
					cnt = 1;
					aWin = false;
				}
			}
			else
			{
				if(winA(a[i], b[i])) 
				{
					max = Math.max(max, cnt);
					cnt = 1;
					aWin = true;
				}
				else cnt++;
			}
		}
		max = Math.max(max, cnt);
		System.out.println(max);
	}

	private static boolean winA(int a, int b) {
		if(a == b)
		{
			if(aWin) return false;
			else return true;
		}
		if(a == 1 && b == 2) return false;
		if(a == 1 && b == 3) return true;
		if(a == 2 && b == 1) return true;
		if(a == 2 && b == 3) return false;
		if(a == 3 && b == 1) return false;
		if(a == 3 && b == 2) return true;
		return false;
	}
}