import java.util.*;
 
public class Main {
	static char[][] map = new char[4][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char start = 'A';
        int res = 0;
        for(int i = 0; i < 4; i++)
        	map[i] = sc.next().toCharArray();
        int i = 0, j = 0;
        while(start <= 'O')
        {
        	if(start != map[i][j])
        		res += find(start, i, j);
    		
        	start++;
        	j++;
        	if(j == 4)
        	{
        		i++;
        		j = 0;
        	}
        	if(start > 'O') break;
        }
        System.out.println(res);
    }
	private static int find(char c, int a, int b) {
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				if(c == map[i][j])
					return Math.abs(a - i) + Math.abs(b - j);
		return 0;
	}
}