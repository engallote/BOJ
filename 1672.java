import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Vector<Character> v = new Vector<>();
		String N = br.readLine();
		String s = br.readLine();
		
		for(int i = 0; i < s.length(); i++)
			v.add(s.charAt(i));
		
		char[][] ch = new char[128][128];
		ch['A']['A'] = 'A';
		ch['A']['G'] = 'C';
		ch['A']['C'] = 'A';
		ch['A']['T'] = 'G';
		ch['G']['A'] = 'C';
		ch['G']['G'] = 'G';
		ch['G']['C'] = 'T';
		ch['G']['T'] = 'A';
		ch['C']['A'] = 'A';
		ch['C']['G'] = 'T';
		ch['C']['C'] = 'C';
		ch['C']['T'] = 'G';
		ch['T']['A'] = 'G';
		ch['T']['G'] = 'A';
		ch['T']['C'] = 'G';
		ch['T']['T'] = 'T';
		int idx1 = v.size() - 2, idx2 = v.size() - 1;
		while(v.size() > 1)
		{
			char c1 = v.get(idx1), c2 = v.get(idx2);
			v.remove(idx2);
			v.remove(idx1);
			v.add(ch[c1][c2]);
			idx2 = v.size() - 1;
			idx1 = idx2 - 1;
		}
		System.out.println(v.get(0));
	}
}