import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			double[] arr = new double[5];
			arr[0] = sc.nextLong()/8.0;
			arr[1] = sc.nextLong()/8.0;
			arr[2] = sc.nextLong()/4.0;
			arr[3] = sc.nextLong();
			arr[4] = sc.nextLong()/9.0;
			Arrays.sort(arr);
			int banana = sc.nextInt();
			int berry = sc.nextInt() / 30;
			int choco = sc.nextInt() / 25;
			int wal = sc.nextInt() / 10;
			
			double possible = arr[0] * 16;
			long res = banana + berry + choco + wal;
			if(possible >= res)
				System.out.println(res);
			else
				System.out.println((int)possible);
		}
	}
}