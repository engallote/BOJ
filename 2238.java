import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int U = sc.nextInt();
		int N = sc.nextInt();
		String[] arr = new String[U+1];
		Arrays.fill(arr, "");
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			int money = sc.nextInt();
			arr[money] += name + " ";
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= U; i++)
			if(arr[i].length() > 0)
			{
				arr[i] = arr[i].trim();
				String[] str = arr[i].split(" ");
				pq.add(new Pair(i, str));
			}
		System.out.println(pq.peek().str[0] + " " + pq.peek().m);
	}
}
class Pair implements Comparable<Pair>{
	int m;
	String[] str;
	Pair(int m, String[] str)
	{
		this.m = m;
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.str.length > this.str.length) return -1;
		else if(o.str.length == this.str.length)
		{
			if(o.m > this.m) return -1;
			else return 1;
		}
		else return 1;
	}
}