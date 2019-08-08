import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<Pair> arr = new ArrayList<>();
		for(int i = 0 ; i < N; i++)
		{
			String s = sc.next();
			if(s.equals("order"))
			{
				int table = sc.nextInt();
				int time = sc.nextInt();
				arr.add(new Pair(table, time));
			}
			else if(s.equals("complete"))
			{
				int table = sc.nextInt();
				for(int j = 0; j < arr.size(); j++)
					if(arr.get(j).table == table)
					{
						arr.remove(j);
						break;
					}
			}
			else Collections.sort(arr);
			if(arr.isEmpty())
				System.out.println("sleep");
			else
			{
				for(Pair p : arr)
					System.out.print(p.table + " ");
				System.out.println();
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int table, time;
	Pair(int table, int time)
	{
		this.table = table;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.time > this.time) return -1;
		else if(o.time == this.time)
		{
			if(o.table > this.table) return -1;
			else return 1;
		}
		else return 1;
	}
}