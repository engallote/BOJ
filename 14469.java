import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Pair[] arr = new Pair[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		Arrays.sort(arr);
		
		int time = 0;
		for(int i = 0; i < N; i++)
		{
			if(time <= arr[i].x)
				time = arr[i].x + arr[i].y;
			else
				time += arr[i].y;
		}
		
		System.out.println(time);
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
		else if(o.x == this.x)
		{
			if(o.y > this.y) return -1;
			else if(o.y == this.y) return 0;
			else return 1;
		}
		else return 1;
	}
}