import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Pair[] arr = new Pair[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = new Pair(sc.nextInt(), sc.nextInt());
        Arrays.sort(arr);
        
        int start = arr[0].endTime, end = arr[N-1].endTime;
        boolean flag = false;
        while(true)
        {
        	int idx = 0, time = start;
        	flag = true;
        	while(idx < N)
        	{
        		time += arr[idx].time;
        		if(time <= arr[idx].endTime)
        			idx++;
        		else
        		{
        			flag = false;
        			break;
        		}
        	}
        	
        	if(flag) break;
        	start--;
        	if(start < 0)
        	{
        		start = -1;
        		break;
        	}
        }
        System.out.println(start);
    }
}
class Pair implements Comparable<Pair>{
	int time, endTime;
	Pair(int time, int endTime)
	{
		this.time = time;
		this.endTime = endTime;
	}
	@Override
	public int compareTo(Pair o) {
		return o.endTime > this.endTime ? -1 : 1;
	}
}