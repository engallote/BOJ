import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Pair> v = new Vector<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        int start = 0;
        for(int i = 0; i < N-M+1; i++)
        {
        	for(int j = start; j < N; j++)
        	{
        		if(v.size() >= M)
        		{
        			start = j;
        			break;
        		}
        		v.add(new Pair(j, arr[j]));
        	}
        	int d = sc.nextInt() - 1;
//        	System.out.println(v.size());
        	v.sort(null);
        	v.remove(d);
        }
        
        v.sort(null);
        for(Pair p : v)
        	System.out.print(p.num + " ");
    }
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num)
	{
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num)
		{
			if(o.idx > this.idx) return -1;
			else return 1;
		}
		else return 1;
	}
}