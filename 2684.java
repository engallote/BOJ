import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashMap<String, Integer> hs = new HashMap<>();
		hs.put("HHH", 7);
		hs.put("HHT", 6);
		hs.put("HTH", 5);
		hs.put("HTT", 4);
		hs.put("THH", 3);
		hs.put("THT", 2);
		hs.put("TTH", 1);
		hs.put("TTT", 0);
		
		for(int t = 0; t < T; t++)
		{
			char[] c = sc.next().toCharArray();
			int[] res = new int[8];
			for(int i = 0; i < 40-2; i++)
			{
				String str = c[i] + "" + c[i+1] + "" + c[i+2];
				res[hs.get(str)]++;
			}
			for(int i = 0; i < 8; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}
}