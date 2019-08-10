import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	char c = sc.next().charAt(0);
        	if(c == '#') break;
        	String str = sc.nextLine().toLowerCase();
        	int[] arr = new int[26];
        	for(int i = 0; i < str.length(); i++)
        	{
        		if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
        			arr[str.charAt(i)-'a']++;
        	}
        	
        	System.out.println(c + " " + arr[c - 'a']);
        }
    }
}