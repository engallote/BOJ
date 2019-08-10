import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] score = new int[N];
		
		for(int i = 0; i < N; i++)
			score[i] = sc.nextInt();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++)
		{
			int num = sc.nextInt();
			int sum = 0;
			for(int j = 0; j < N; j++)
			{
				char c = sc.next().charAt(0);
				if(c == 'O')
					sum += score[j];
			}
			pq.add(new Pair(num, sum));
		}
		
		System.out.println(pq.peek().num + " " + pq.peek().sum);
	}
}
class Pair implements Comparable<Pair>{
	int num, sum;
	Pair(int num, int sum){
		this.num = num;
		this.sum = sum;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.sum > this.sum) return 1;
		else if(o.sum < this.sum) return -1;
		else
		{
			if(o.num > this.num) return -1;
			else if(o.num < this.num) return 1;
			else return 0;
		}
	}
}