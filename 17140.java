import java.util.*;
 
public class Main {
    static int N, res = 0, w, h;
    static int[] num = new int[101];
    static int[][] arr = new int[105][105];
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = 3;
        h = 3;
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int k = sc.nextInt();
        res = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 3; j++)
        		arr[i][j] = sc.nextInt();
        
        if(arr[x][y] == k)
        {
        	System.out.println(0);
        	return;
        }
        
        for(int t = 1; t <= 100; t++)
        {
        	if(w > h)//세로로
        		changeHor();
        	else//가로로
        		changeVer();
        	
        	if(arr[x][y] == k)
        	{
        		res = t;
        		break;
        	}
        }
        if(res == Integer.MAX_VALUE)
        	res = -1;
        System.out.println(res);
    }
	private static void changeVer() {
		int max = 0, maxNum = 0, idx;
		for(int i = 0; i < h; i++)
		{
			Arrays.fill(num, 0);
			for(int j = 0; j < w; j++)
			{
				maxNum = Math.max(maxNum, arr[i][j]);
				num[arr[i][j]]++;
				arr[i][j] = 0;
			}
			idx = 0;
			pq.clear();
			for(int k = 1; k <= maxNum; k++)
				if(num[k] > 0) pq.add(new Pair(k, num[k]));
			
			while(!pq.isEmpty())
			{
				arr[i][idx++] = pq.peek().x;
				arr[i][idx++] = pq.poll().cnt;
			}
			max = Math.max(max, idx);
		}
		w = Math.min(max, 101);
	}
	private static void changeHor() {
		int max = 0, maxNum = 0, idx;
		for(int j = 0; j < w; j++)
		{
			Arrays.fill(num, 0);
			for(int i = 0; i < h; i++)
			{
				maxNum = Math.max(maxNum, arr[i][j]);
				num[arr[i][j]]++;
				arr[i][j] = 0;
			}
			idx = 0;
			pq.clear();
			for(int i = 1; i <= maxNum; i++)
				if(num[i] > 0) pq.add(new Pair(i, num[i]));
			
			while(!pq.isEmpty())
			{
				arr[idx++][j] = pq.peek().x;
				arr[idx++][j] = pq.poll().cnt;
			}
			max = Math.max(max, idx);
		}
		h = Math.min(max, 101);
	}
}
class Pair implements Comparable<Pair>{
	int x, cnt;
	Pair(int x, int cnt)
	{
		this.x = x;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return -1;
		else if(o.cnt == this.cnt)
		{
			if(o.x > this.x) return -1;
			else return 1;
		}
		else return 1;
	}
}