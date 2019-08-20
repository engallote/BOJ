import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[2*N+1];
        Vector<Integer> a = new Vector<>(), b = new Vector<>();
        for(int i = 0; i < N; i++)
        {
        	int num = sc.nextInt();
        	arr[num]++;
        	a.add(num);
        }
        
        for(int i = 1; i <= 2*N; i++)
        	if(arr[i] == 0)
        		b.add(i);
        a.sort(null);
        b.sort(null);
        int pan = 0;
        boolean flag = false;
        while(!a.isEmpty() && !b.isEmpty())
        {
        	flag = false;
        	for(int i = 0; i < a.size(); i++)
        		if(a.get(i) > pan)
        		{
        			pan = a.get(i);
        			a.remove(i);
        			flag = true;
        			break;
        		}
        	if(a.isEmpty()) break;
        	if(!flag) pan = 0;
//        	System.out.println(pan);
        	flag = false;
        	for(int i = 0; i < b.size(); i++)
        		if(b.get(i) > pan)
        		{
        			pan = b.get(i);
        			b.remove(i);
        			flag = true;
        			break;
        		}
        	if(b.isEmpty()) break;
        	if(!flag) pan = 0;
//        	System.out.println(pan);
        }
        
        System.out.println(b.size());
        System.out.println(a.size());
    }
}