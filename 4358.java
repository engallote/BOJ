import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, Double> per = new HashMap<>();
        PriorityQueue<String> name = new PriorityQueue<>();
        int cnt = 0;
        while(sc.hasNext())
        {
        	String str = sc.nextLine();
//        	if(str.equals("0")) break;
        	if(count.containsKey(str))
        	{
        		int value = count.get(str) + 1;
        		count.remove(str);
        		count.put(str, value);
        	}
        	else
        		count.put(str, 1);
        	cnt++;
        }
        
        Iterator<String> it = count.keySet().iterator();
        while(it.hasNext())
        {
        	String key = it.next();
        	int value = count.get(key);
        	name.add(key);
        	
        	double tmp = (double) value / (double) cnt;
        	per.put(key, tmp);
        }
        
        while(!name.isEmpty())
        {
        	String s = name.poll();
        	double tmp = per.get(s) * 100;
        	
        	System.out.printf("%s %.4f\n", s, tmp);
        }
    }
}