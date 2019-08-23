import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] a = new int[A];
		int[] b = new int[B];
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < A; i++)
		{
			a[i] = sc.nextInt();
			hs.add(a[i]);
		}
		int size = hs.size();
		for(int i = 0; i < B; i++)
		{
			b[i] = sc.nextInt();
			if(hs.contains(b[i]))
				size--;
		}
		
		int alen = size, blen = 0;
		hs.clear();
		for(int i = 0; i < B; i++)
			hs.add(b[i]);
		size = hs.size();
		for(int i = 0; i < A; i++)
			if(hs.contains(a[i]))
				size--;
		blen = size;
		System.out.println(alen+blen);
	}
}