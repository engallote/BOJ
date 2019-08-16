import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	StringBuilder a = new StringBuilder(), b = new StringBuilder(), res = new StringBuilder();
            a.append(sc.next());
            b.append(sc.next());
            a.reverse();
            b.reverse();
            
            long num = Long.parseLong(a.toString()) + Long.parseLong(b.toString());
            res.append(num);
            res.reverse();
            System.out.println(Long.parseLong(res.toString()));
        }
	}
}