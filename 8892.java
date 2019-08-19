import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			int N = sc.nextInt();
			String[] str = new String[N];
			for(int i = 0; i < N; i++)
				str[i] = sc.next();
			
			String res = "0";
			boolean flag = false;
			for(int i = 0; i < N; i++)
			{
				for(int j = i + 1; j < N; j++)
				{
					StringBuilder tmp = new StringBuilder();
					tmp.append(str[i]);
					tmp.append(str[j]);
					String tmp2 = tmp.toString();
					tmp.reverse();
//					System.out.println(tmp2 +" " + tmp.toString());
					if(tmp2.equals(tmp.toString()))
					{
						flag = true;
						res = tmp2;
						break;
					}
					
					tmp = new StringBuilder();
					tmp.append(str[j]);
					tmp.append(str[i]);
					tmp2 = tmp.toString();
					tmp.reverse();
//					System.out.println(tmp2 +" " + tmp.toString());
					if(tmp2.equals(tmp.toString()))
					{
						flag = true;
						res = tmp2;
						break;
					}
				}
				if(flag) break;
			}
			System.out.println(res);
		}
	}
}