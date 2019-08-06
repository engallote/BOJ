import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] map = new int[N + 1][M + 1];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        String res = "OK";
        int A = sc.nextInt();
        int B = sc.nextInt();
        Vector<Pair> v = new Vector<>();
        v.addElement(new Pair(0,0,0));
        
        for(int i = 1; i <= A; i++)
        {
        	int y = sc.nextInt();
        	int x = (N + 1) - sc.nextInt();
        	map[x][y] = i;
        	char c = sc.next().charAt(0);
        	switch(c)
        	{
        	case 'E': v.add(new Pair(x, y, 0)); break;
        	case 'S': v.add(new Pair(x, y, 1)); break;
        	case 'W': v.add(new Pair(x, y, 2)); break;
        	case 'N': v.add(new Pair(x, y, 3)); break;
        	}
        }
//        System.out.println();
//        for(int i = 1; i <= N; i++)
//        {
//        	for(int j = 1; j <= M; j++)
//        		System.out.print(map[i][j] + " ");
//        	System.out.println();
//        }
        boolean flag = true;
        for(int i = 0; i < B; i++)
        {
        	int num = sc.nextInt();
        	char c = sc.next().charAt(0);
        	int re = sc.nextInt();
        	if(!flag) continue;
        	if(c == 'F')
        		map[v.get(num).x][v.get(num).y] = 0;
        	while(re > 0)
        	{
        		if(c == 'L')
        			v.get(num).d = (v.get(num).d - 1 < 0 ? 3 : v.get(num).d - 1);
        		else if(c == 'R')
        			v.get(num).d = (v.get(num).d + 1 == 4 ? 0 : v.get(num).d + 1);
        		else
        		{
        			v.get(num).x = v.get(num).x + dx[v.get(num).d];
        			v.get(num).y = v.get(num).y + dy[v.get(num).d];
//        			System.out.println(v.get(num).x + " " + v.get(num).y);
        			if(v.get(num).x < 1 || v.get(num).x > N || v.get(num).y < 1 || v.get(num).y > M)
        			{
        				flag = false;
        				res = "Robot " + num + " crashes into the wall";
        				break;
        			}
        			if(map[v.get(num).x][v.get(num).y] != 0)
        			{
        				flag = false;
        				res = "Robot " + num + " crashes into robot " + map[v.get(num).x][v.get(num).y];
        			}
        		}
        		if(!flag) break;
        		re--;
        	}
        	if(flag && c == 'F')
        		map[v.get(num).x][v.get(num).y] = num;
        }
        System.out.println(res);
    }
}
class Pair{
	int x, y, d;
	Pair(int x, int y, int d)
	{
		this.x = x;
		this.y = y;
		this.d = d;
	}
}