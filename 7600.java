import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		char[] ch = sc.nextLine().toLowerCase().toCharArray();
    		
    		if(ch[0] == '#' && ch.length == 1) break;
    		
    		HashSet<Character> hs = new HashSet<>();
    		for(char c : ch)
    			if('a' <= c && c <= 'z') hs.add(c);
    		
    		System.out.println(hs.size());
    	}
    }
}
