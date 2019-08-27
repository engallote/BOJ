import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		Vector<String> v = new Vector<>();
		String s = "";
		int cnt = 0, f = -1;
		for(int i = 0; i < ch.length; i++)
		{
			s += ch[i];
			cnt++;
			if(cnt == K)
			{
				f *= -1;
				cnt = 0;
				if(f == -1)
				{
					StringBuilder str = new StringBuilder();
					str.append(s);
					str.reverse();
					s = str.toString();
				}
				v.add(s);
				s = "";
			}
		}
		
		for(int i = 0; i < K; i++)
		{
			for(int j = 0; j < v.size(); j++)
				System.out.print(v.get(j).charAt(i));
		}
	}
}