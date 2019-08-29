import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i = 1; i < 10; i++)
			arr[i] = sc.nextInt();
		String s = sc.next();
		String res = "";
		
		int num = -1;
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if(c == 'a' || c == 'b' || c == 'c')
			{
				if(num == 2)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 2)
					{
						if(c == 'a')
							res += j;
						else if(c == 'b')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 2;		
			}
			else if(c == 'd' || c == 'e' || c == 'f')
			{
				if(num == 3)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 3)
					{
						if(c == 'd')
							res += j;
						else if(c == 'e')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 3;		
			}
			else if(c == 'g' || c == 'h' || c == 'i')
			{
				if(num == 4)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 4)
					{
						if(c == 'g')
							res += j;
						else if(c == 'h')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 4;		
			}
			else if(c == 'j' || c == 'k' || c == 'l')
			{
				if(num == 5)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 5)
					{
						if(c == 'j')
							res += j;
						else if(c == 'k')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 5;		
			}
			else if(c == 'm' || c == 'n' || c == 'o')
			{
				if(num == 6)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 6)
					{
						if(c == 'm')
							res += j;
						else if(c == 'n')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 6;		
			}
			else if(c == 'p' || c == 'q' || c == 'r' || c == 's')
			{
				if(num == 7)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 7)
					{
						if(c == 'p')
							res += j;
						else if(c == 'q')
							res += j + "" + j;
						else if(c == 'r')
							res += j + "" + j + "" + j;
						else
							res += j + "" + j + "" + j + "" + j;
						break;
					}
				num = 7;		
			}
			else if(c == 't' || c == 'u' || c == 'v')
			{
				if(num == 8)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 8)
					{
						if(c == 't')
							res += j;
						else if(c == 'u')
							res += j + "" + j;
						else
							res += j + "" + j + "" + j;
						break;
					}
				num = 8;		
			}
			else if(c == 'w' || c == 'x' || c == 'y' || c == 'z')
			{
				if(num == 9)
					res += "#";
				for(int j = 1; j <= 9; j++)
					if(arr[j] == 9)
					{
						if(c == 'w')
							res += j;
						else if(c == 'x')
							res += j + "" + j;
						else if(c == 'y')
							res += j + "" + j + "" + j;
						else
							res += j + "" + j + "" + j + "" + j;
						break;
					}
				num = 9;			
			}
		}
		System.out.println(res);
	}
}