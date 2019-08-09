import java.util.*;

public class Main {
	static int A, B, C;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		boolean[][][] visit = new boolean[A+1][B+1][C+1];
		visit[0][0][C] = true;
		Queue<Water> q = new LinkedList<>();
		q.add(new Water(0, 0, C));
		
		while(!q.isEmpty())
		{
			Water w = q.poll();
//			System.out.println(w.a + " " + w.b + " " + w.c);
			if(w.a == 0)
			{
				if(!pq.contains(w.c))
					pq.add(w.c);
			}
			
			//c -> a
			if(w.c + w.a > A && !visit[A][w.b][w.c + w.a - A])
			{
				q.offer(new Water(A, w.b, w.c + w.a - A));
				visit[A][w.b][w.c + w.a - A] = true;
			}
			if(w.c + w.a <= A && !visit[w.a + w.c][w.b][0])
			{
				q.offer(new Water(w.a + w.c, w.b, 0));
				visit[w.a + w.c][w.b][0] = true;
			}
			//c -> b
			if(w.c + w.b > B && !visit[w.a][B][w.c + w.b - B])
			{
				q.offer(new Water(w.a, B, w.c + w.b - B));
				visit[w.a][B][w.c + w.b - B] = true;
			}
			if(w.c + w.b <= B && !visit[w.a][w.b + w.c][0])
			{
				q.offer(new Water(w.a, w.b + w.c, 0));
				visit[w.a][w.b + w.c][0] = true;
			}
			
			//a -> b
			 if(w.a + w.b > B && !visit[w.a + w.b - B][B][w.c])
			 {
				 q.offer(new Water(w.a + w.b - B, B, w.c));
				 visit[w.a + w.b - B][B][w.c] = true;
			 }
			 if(w.a + w.b <= B && !visit[0][w.b + w.a][w.c])
			 {
				 q.offer(new Water(0, w.b + w.a, w.c));
				 visit[0][w.b + w.a][w.c] = true;
			 }
			 //a -> c
			 if(w.a + w.c > C && !visit[w.a + w.c - C][w.b][C])
			 {
				 q.offer(new Water(w.a + w.c - C, w.b, C));
				 visit[w.a + w.c - C][w.b][C] = true;
			 }
			 if(w.a + w.c <= C && !visit[0][w.b][w.c + w.a])
			 {
				 q.offer(new Water(0, w.b, w.c + w.a));
				 visit[0][w.b][w.c + w.a] = true;
			 }
			 
			 //b -> a
			 if(w.b + w.a > A && !visit[A][w.b + w.a - A][w.c])
			 {
				 q.offer(new Water(A, w.b + w.a - A, w.c));
				 visit[A][w.b + w.a - A][w.c] = true;
			 }
			 if(w.b + w.a <= A && !visit[w.a + w.b][0][w.c])
			 {
				 q.offer(new Water(w.a + w.b, 0, w.c));
				 visit[w.a + w.b][0][w.c] = true;
			 }
			 //b -> c
			 if(w.b + w.c > C && !visit[w.a][w.b + w.c - C][C])
			 {
				 q.offer(new Water(w.a, w.b + w.c - C, C));
				 visit[w.a][w.b + w.c - C][C] = true;
			 }
			 if(w.b + w.c <= C && !visit[w.a][0][w.c + w.b])
			 {
				 q.offer(new Water(w.a, 0, w.c + w.b));
				 visit[w.a][0][w.c + w.b] = true;
			 }
		}
		while(!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}
class Water{
	int a, b, c;
	Water(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}