import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int len = c.length;
		ArrayList<Character>[] key = new ArrayList[8];
		String s = "CHICKENS";
		
		for(int i = 0; i < 8; i++)
		{
			key[i] = new ArrayList<>();
			char ch = s.charAt(i);
			
			while(key[i].size() < 26)
			{
				key[i].add(ch);
				if(ch == 'Z') ch = 'A';
				else ch++;
			}
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < len; i++)
		{
			int num = c[i] - 'A';
			char ch = c[i];
			for(int j = 0; j < 8; j++)
			{
				ch = key[j].get(num);
				num = ch - 'A';
			}
			res.append(ch);
			//Åé´Ï È¸Àü
			char tmp = key[0].get(0);
			key[0].remove(0);
			key[0].add(tmp);
		}
		System.out.println(res.toString());
	}
}