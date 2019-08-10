import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++)
			arr[i] = sc.nextInt();
		int student = sc.nextInt();
		boolean[] visit = new boolean[301];
		
		if(arr[0] == 1 || arr[1] == 1 || arr[2] == 1)
		{
			System.out.println(1);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(student);
		
		while(!q.isEmpty())
		{
			int x = q.poll();
			
			if(x == 0)
			{
				System.out.println(1);
				return;
			}
			
			if(x - arr[0] >= 0 && !visit[x - arr[0]])
			{
				visit[x - arr[0]] = true;
				q.add(x - arr[0]);
			}
			if(x - arr[1] >= 0 && !visit[x - arr[1]])
			{
				visit[x - arr[1]] = true;
				q.add(x - arr[1]);
			}
			if(x - arr[2] >= 0 && !visit[x - arr[2]])
			{
				visit[x - arr[2]] = true;
				q.add(x - arr[2]);
			}
		}
		System.out.println(0);
	}
}