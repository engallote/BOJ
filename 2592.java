import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hs = new HashMap<>();
		int avg = 0;
		for(int i = 0; i < 10; i++)
		{
			int num = sc.nextInt();
			avg += num;
			if(hs.containsKey(num))
			{
				int value = hs.get(num) + 1;
				hs.remove(num);
				hs.put(num, value);
			}
			else
				hs.put(num, 1);
		}
		avg /= 10;
		Iterator<Integer> it = hs.keySet().iterator();
		int num = 0, cnt = 0;
		while(it.hasNext())
		{
			int key = it.next();
			int value = hs.get(key);
			
			if(cnt < value)
			{
				cnt = value;
				num = key;
			}
		}
		
		System.out.println(avg);
		System.out.println(num);
	}
}