import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++)
        {
        	int k = sc.nextInt();
        	pq.add(k+1);
        }
        
        int cnt = 1;
        while(!pq.isEmpty())
        {
        	int p = pq.poll();
        	if(cnt >= p) break;
        	cnt++;
        }
        System.out.println(cnt);
	}
}