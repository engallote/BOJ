import java.util.*;
 
public class Main {
    static int N, M, T, res;
    static int[][] arr, index, map;
    static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, 1, -1};
    static ArrayList<Pair> shark = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        arr = new int[N+1][M+1];
        index = new int[N+1][M+1];
        map = new int[N+1][M+1];
        int idx = 0;
        for(int i = 0; i < T; i++)
        {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	int s = sc.nextInt();
        	int d = sc.nextInt();
        	int size = sc.nextInt();
        	arr[x][y] = size;
        	index[x][y] = idx++; 
        	shark.add(new Pair(x, y, s, d, size));
        }
        boolean[] chk = new boolean[idx];
        Queue<Pair> q = new LinkedList<>();
        int res = 0;
        for(int j = 1; j <= M; j++)
        {
        	//상어 잡기
        	for(int i = 1; i <= N; i++)
        		if(arr[i][j] != 0)
        		{
        			res += arr[i][j];
        			arr[i][j] = 0;
        			chk[index[i][j]] = true;//더 이상 카운트 하지 않기 위해
        			break;
        		}
        	for(int i = 1; i <= N; i++)
        	{
        		Arrays.fill(arr[i], 0);
        		Arrays.fill(index[i], 0);
        	}
        	
        	//상어 이동
        	for(int k = 0; k < shark.size(); k++)
        	{
        		if(chk[k]) continue; 
        		Pair p = shark.get(k);
        		int speed = p.speed, x = p.x, y = p.y, d = p.dir;
        		for(int s = 0; s < speed; s++)
        		{
        			if(x + dx[d] < 1 || x + dx[d] > N || y + dy[d] < 1 || y + dy[d] > M)
        			{
        				if(d <= 2) d = (d == 1) ? 2 : 1;
        				else d = (d == 3) ? 4 : 3;
        			}
        			x += dx[d];
        			y += dy[d];
//        			System.out.println(x + " " + y);
        		}
        		shark.get(k).x = x;
        		shark.get(k).y = y;
        		shark.get(k).dir = d;
        		if(arr[x][y] != 0)//이미 차지하고 있는 상어가 있다
        		{
        			if(arr[x][y] < p.size)//이 상어가 더 크다
        			{
        				arr[x][y] = p.size;
        				chk[index[x][y]] = true;
        				index[x][y] = k;
        			}
        			else
        				chk[k] = true;
        		}
        		else
        		{
        			arr[x][y] = p.size;
        			index[x][y] = k;
        		}
        	}
        }
        System.out.println(res);
    }
}
class Pair{
	int x, y, speed, dir, size;
	Pair(int x, int y, int speed, int dir, int size)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
}