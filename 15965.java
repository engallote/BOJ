import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt() - 1;
		boolean[] chk = new boolean[10000001];
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 2; i <= 10000000; i++)
		{
			if(chk[i]) continue;
			arr.add(i);
			for(int j = i + i; j <= 10000000; j+=i) chk[j] = true;
		}
		System.out.println(arr.get(K));
	}
}