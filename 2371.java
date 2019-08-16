import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder[] str = new StringBuilder[N];
        PriorityQueue<Integer>[] arr = new PriorityQueue[N];
        for(int i = 0; i < N; i++)
        {
        	str[i] = new StringBuilder();
        	arr[i] = new PriorityQueue<>();
        	while(true)
        	{
        		int num = sc.nextInt();
        		if(num == -1) break;
        		arr[i].add(num);
        	}
        }
        HashSet<String> hs = new HashSet<>();
        
        int cnt = 0;
        while(true)
        {
        	cnt++;
        	for(int i = 0; i < N; i++)
        	{
        		if(arr[i].isEmpty()) str[i].append(0);
        		else str[i].append(arr[i].poll());
        	}
        	
        	for(int i = 0; i < N; i++)
        	{
//        		System.out.print(str[i].toString() + " ");
        		hs.add(str[i].toString());
        	}
//        	System.out.println("--> " + hs.size());
        	if(hs.size() == N) break;
        	hs.clear();
        }
        System.out.println(cnt);
	}
}