import java.util.*;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] str = new String[N];
		int[] alp = new int[26];
		int sum = 0;
		
		for(int i = 0; i < N; i++)
			str[i] = sc.next();
		
		Arrays.sort(str);
		String s = "";
		for(int i = 0; i < M; i++)
		{
			Arrays.fill(alp, 0);
			int max = -1, number = 0;
			for(int j = 0; j < N; j++)
			{
				int num = str[j].charAt(i) - 'A';
				alp[num]++;
				if(max < alp[num])
				{
					max = alp[num];
					number = num;
				}
			}
			for(int j = 0; j < 26; j++)
				if(max == alp[j])
				{
					number = j;
					break;
				}
			s += (char)(number + 'A');
			for(int j = 0; j < 26; j++)
				if(j != number && alp[j] != 0)
					sum += alp[j];
		}
		System.out.println(s);
		System.out.println(sum);
	}
}