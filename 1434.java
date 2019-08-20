import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] box = new int[N], book = new int[M];
        for(int i = 0; i < N; i++)
        	box[i] = sc.nextInt();
        for(int i = 0; i < M; i++)
        	book[i] = sc.nextInt();
        
        int idx = 0, idx2 = 0;
        
        while(idx2 < M)
        {
        	if(box[idx] >= book[idx2])
        	{
        		box[idx] -= book[idx2];
        		idx2++;
        	}
        	else
        		idx++;
        	if(idx == N) break;
        }
        for(int i = 0; i < N; i++)
        {
//        	System.out.println(box[i]);
        	res += box[i];
        }
        System.out.println(res);
    }
}