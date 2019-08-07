import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][][] number = {{{'*','*','*'},{'*',' ','*'},{'*',' ','*'},{'*',' ','*'},{'*','*','*'}},
				{{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'}},
				{{'*','*','*'},{' ',' ','*'},{'*','*','*'},{'*',' ',' '},{'*','*','*'}},
				{{'*','*','*'},{' ',' ','*'},{'*','*','*'},{' ',' ','*'},{'*','*','*'}},
				{{'*',' ','*'},{'*',' ','*'},{'*','*','*'},{' ',' ','*'},{' ',' ','*'}},
				{{'*','*','*'},{'*',' ',' '},{'*','*','*'},{' ',' ','*'},{'*','*','*'}},
				{{'*','*','*'}, {'*',' ',' '},{'*','*','*'},{'*',' ','*'},{'*','*','*'}},
				{{'*','*','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'}},
				{{'*','*','*'},{'*',' ','*'},{'*','*','*'},{'*',' ','*'},{'*','*','*'}},
				{{'*','*','*'},{'*',' ','*'},{'*','*','*'},{' ',' ','*'},{'*','*','*'}}};
		
//		String z = "***\n* *\n* *\n* *\n***";
		char[][] arr = new char[5][50];
		int len = 0;
		for(int i = 0; i < 5; i++)
		{
			arr[i] = sc.nextLine().toCharArray();
			len = arr[i].length;
		}
		char[][] tmp = new char[5][3];
		int num = 0, idx = 0, curNum = 0, col = 0;
		boolean flag = true;
		
		while(true)
		{
			curNum = -1;
			
			for(int j = 0; j < 5; j++)
			{
				for(int i = idx; i < Math.min(idx + 3, len); i++)
				{
//					System.out.println(j + " " + i);
					tmp[j][col] = arr[j][i];
					col++;
				}
				col = 0;
			}
				
			for(int k = 0; k < 10; k++)
			{
				flag = true;
				for(int i = 0; i < 5; i++)
				{
					for(int j = 0; j < 3; j++)
						if(tmp[i][j] != number[k][i][j]) 
						{
							flag = false;
							break;
						}
					if(!flag) break;
				}
				if(flag)
				{
					curNum = k;
					break;
				}
			}
			if(curNum == -1)
			{
				num = -1;
				break;
			}
			num += curNum;
			idx += 4;
			if(idx >= len) break;
			num *= 10;
		}
		
		if(num == -1 || num % 6 != 0) System.out.println("BOOM!!");
		else System.out.println("BEER!!");
	}
}