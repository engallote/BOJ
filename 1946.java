import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0; t < tc; t++)
		{
			int N = sc.nextInt();
			Pair[] arr = new Pair[N+1];
			for(int i = 0; i < N; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a] = new Pair(a, b);
			}
			
			int cnt = 1, num = arr[1].y;
			
			for(int i = 2; i <= N; i++)
				if(arr[i].y < num)
				{
					num = arr[i].y;
					cnt++;
				}
			System.out.println(cnt);
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return -1;
		else if(o.x == this.x){
			if(o.y > this.y) return -1;
			else if(o.y == this.y) return 0;
			else return 1;
		}
		else return 1;
	}
}