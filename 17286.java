import java.util.*;

public class Main {
	static double res;
	static double[][] arr;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		res = Double.MAX_VALUE;
		arr = new double[3][2];
		chk = new boolean[3];
		
		for(int i = 0; i < 3; i++)
		{
			arr[i][0] = sc.nextDouble();
			arr[i][1] = sc.nextDouble();
		}
		
		solve(x, y, 0.0, 0);
		System.out.println((int)res);
	}
	private static void solve(double x, double y, double sum, int cnt) {
		if(cnt == 3)
		{
//			System.out.println(sum);
			res = Math.min(res, sum);
			return;
		}
		
		for(int i = 0; i < 3; i++)
			if(!chk[i])
			{
				chk[i] = true;
//				solve(arr[i][0], arr[i][1], sum + Math.abs(x - arr[i][0]) + Math.abs(y - arr[i][1]), cnt + 1);
				double tmp = Math.abs(arr[i][0]-x) * Math.abs(arr[i][0]-x) + Math.abs(arr[i][1]-y) * Math.abs(arr[i][1]-y);
				solve(arr[i][0], arr[i][1], sum + Math.sqrt(tmp), cnt + 1);
				chk[i] = false;
			}
	}
}