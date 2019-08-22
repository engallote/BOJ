import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		
		HashSet<Integer> hs = new HashSet<>();
		Vector<Integer> v = new Vector<>();
		v.add((N * N) % P);
		int idx = 0, start = 0;
		while(true)
		{
			int num = (v.get(idx) * N) % P;
			if(v.contains(num))
			{
				for(int i = 0; i < v.size(); i++)
					if(v.get(i) == num)
					{
						start = i;
						break;
					}
				break;
			}
			v.add(num);
			idx++;
		}
		
		for(int i = start; i < v.size(); i++)
			hs.add(v.get(i));
		
		System.out.println(hs.size());
	}
}