import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//        Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] chk = new boolean[50050];
        chk[0] = chk[1] = true;
        int[] arr = new int[1000000];
        int idx = 0;
        for(int i = 2; i < 50050; i++)
        {
        	if(chk[i]) continue;
        	arr[idx++] = i;
        	for(int j = i + i; j < 50050; j+=i)
        		chk[j] = true;
        }
        int tc = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	try{
        		int K = Integer.parseInt(br.readLine());
            	PriorityQueue<Integer> pq = new PriorityQueue<>();
            	pq.add(Integer.MAX_VALUE);
            	for(int i = 0; i < idx; i++)
            	{
            		for(int j = i + 1; j < idx; j++)
            		{
            			int mul = arr[i] * arr[j];
            			if(mul > 100001) continue;
            			if(mul >= K && pq.peek() > mul)
            				pq.add(mul);
            		}
            	}
            	if(pq.peek() == Integer.MAX_VALUE)
            		bw.write("100001\n");
            	else
            		bw.write(pq.poll()+"\n");
        	}
        	catch(NumberFormatException e)
        	{
        		bw.write("100001\n");
        	}
        }
        bw.flush();
	}
}