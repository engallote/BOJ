import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 0; t < tc; t++)
        {
        	String s1 = sc.next();
        	String s2 = sc.next();
        	
        	if(s1.length() != s2.length())
        	{
        		System.out.println(s1 + " & " + s2 + " are NOT anagrams.");
        		continue;
        	}
        	char[] a = s1.toCharArray();
        	char[] b = s2.toCharArray();
        	
        	int[] alp1 = new int[26], alp2 = new int[26];
        	for(int i = 0; i < a.length; i++)
        	{
        		alp1[a[i] - 'a']++;
        		alp2[b[i] - 'a']++;
        	}
        	String res = " are anagrams.";
        	for(int i = 0; i < 26; i++)
        		if(alp1[i] != alp2[i])
        		{
        			res = " are NOT anagrams.";
        			break;
        		}
        	System.out.println(s1 + " & " + s2 + res);
        }
    }
}