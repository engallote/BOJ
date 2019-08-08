import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int R = sc.nextInt();
        	int C = sc.nextInt();
        	char[] tmp = sc.next().toCharArray();
        	int r = 0, c = 0, idx = 0, len = R * C, d = 0;
        	int[][] arr = new int[R][C];
        	for(int i = 0; i < R; i++)
        	{
        		for(int j = 0; j < C; j++)
        			arr[i][j] = tmp[idx++] - '0';
        	}
        	
//        	for(int i = 0; i < R; i++)
//        	{
//        		for(int j = 0; j < C; j++)
//        			System.out.print(arr[i][j]);
//        		System.out.println();
//        	}
        	boolean[][] chk = new boolean[R][C];
        	int cnt = 0;
        	idx = 0;
        	String str = "";
        	Queue<String> q = new LinkedList<>();
        	while(idx <= len)
        	{
        		cnt = 0;
        		while(r + dx[d] < 0 || r + dx[d] >= R || c + dy[d] < 0 || c + dy[d] >= C || chk[r+dx[d]][c+dy[d]])
        		{
        			cnt++;
        			d = (d + 1) % 4;
        			if(cnt >= 5) break;
        			continue;
        		}
        		if(cnt >= 5) break;
//        		System.out.println(r + " " + c);
        		str += arr[r][c];
        		if(str.length() == 5)
        		{
        			q.add(str);
//        			System.out.println(str);
        			str = "";
        		}
        		chk[r][c] = true;
        		r += dx[d];
        		c += dy[d];
        		idx++;
        	}
        	for(int i = 0; i < R; i++)
        	{
        		for(int j = 0; j < C; j++)
        			if(!chk[i][j]) str += arr[i][j];
//        		System.out.println();
        	}
        	while(str.length() < 5)
        		str += "0";
        	if(str.contains("1"))
        		q.add(str);
//        	System.out.println(str);
        	StringBuilder ans = new StringBuilder();
        	while(!q.isEmpty())
        	{
        		int num = Integer.parseInt(q.poll(), 2);
//        		System.out.println(num);
        		if(num == 0)
        			ans.append(" ");
        		else
        			ans.append((char)(num - 1 + 'A'));
        	}
        	System.out.println(ans.toString().trim());
        }
    }
}