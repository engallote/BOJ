import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();//길이
		int L = sc.nextInt();//최대하중
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
			q.offer(sc.nextInt());
		
		Queue<Pair> q2 = new LinkedList<Pair>();
		int sum = 0;//다리 위 무게
		int size = 0, cnt = 0, time = 1;
		boolean out = false;
		while(!q.isEmpty() || !q2.isEmpty())
		{
//			System.out.print(time + " : ");
			out = false;
			//다리 끝에 있는 차 빼기
			size = q2.size();
			while(size > 0)
			{
				size--;
				Pair p = q2.poll();
				if(!out && p.time >= W)
				{
					out = true;
					cnt--;
					sum -= p.num;
//					System.out.print(p.num +" out, ");
					continue;
				}
				q2.offer(new Pair(p.num, p.time + 1));
			}
			//비어있으면 진입
			if(cnt < W && !q.isEmpty() && sum + q.peek() <= L)
			{
				cnt++;
				sum += q.peek();
//				System.out.print(q.peek() + " in, ");
				q2.offer(new Pair(q.poll(), 1));
			}
//			System.out.println();
			if(q.isEmpty() && q2.isEmpty()) break;
			time++;
		}
		System.out.println(time);
	}
}
class Pair{
	int num, time;
	Pair(int num, int time){
		this.num = num;
		this.time = time;
	}
}