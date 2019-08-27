import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			pq.add(new Pair(sc.nextInt(), sc.nextInt()));
		
		while(!pq.isEmpty())
			System.out.println(pq.peek().x + " " + pq.poll().y);
	}	
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x < this.x) return 1;
		else if(o.x == this.x)
		{
			if(o.y > this.y) return -1;
			else if(o.y < this.y) return 1;
			else return 0;
		}
		else return -1;
	}
}