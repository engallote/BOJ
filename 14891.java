import java.util.*;

public class Main {
	static int[][] arr = new int[5][8];
	static boolean[] visit = new boolean[5];
	static boolean[][] chk = new boolean[5][5];
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 1; i <= 4; i++)
        {
        	char[] c = sc.next().toCharArray();
        	for(int j = 0; j < 8; j++)
        		arr[i][j] = c[j] - '0';
        }
        
        int K = sc.nextInt();
        for(int t = 0; t < K; t++)
        {
        	int num = sc.nextInt();
        	int rot = sc.nextInt();
        	
        	for(int i = 0; i <= 4; i++)
        		Arrays.fill(chk[i], false);
        	Arrays.fill(visit, false);
        	
        	for(int i = 2; i <= 4; i++)
        		if(arr[i-1][2] != arr[i][6])
        			chk[i-1][i] = chk[i][i-1] = true;
        	if(rot == 1)
        		rotateRight(num);//시계방향
        	else
        		rotateLeft(num);//반시계방향
        }
        int res = 0;
        for(int i = 1; i <= 4; i++)
        	if(arr[i][0] == 1)
        		res += (1<<(i-1));
        System.out.println(res);
	}
	private static void rotateLeft(int num) {
		if(visit[num]) return;
		visit[num] = true;
		int tmp = arr[num][0];
		for(int i = 0; i < 7; i++)
			arr[num][i] = arr[num][i+1];
		arr[num][7] = tmp;
		if(num + 1 <= 4 && chk[num][num+1]) rotateRight(num+1);
		if(num - 1 >= 1 && chk[num][num-1]) rotateRight(num-1);
	}
	private static void rotateRight(int num) {
		if(visit[num]) return;
		visit[num] = true;
		int tmp = arr[num][7];
		for(int i = 7; i > 0; i--)
			arr[num][i] = arr[num][i-1];
		arr[num][0] = tmp;
		
		if(num + 1 <= 4 && chk[num][num+1]) rotateLeft(num+1);
		if(num - 1 >= 1 && chk[num][num-1]) rotateLeft(num-1);
	}
}