import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < tc; t++)
        {
        	char[] c = br.readLine().toCharArray();
        	Stack<Character> st1 = new Stack<>(), ready = new Stack<>();
        	int idx = 0, len = c.length;
        	for(int i = 0; i < len; i++)
        	{
//        		System.out.println(idx + " " + st1.size() + " " + ready.size());
        		if((c[i] >= 'A' && c[i] <= 'Z') || (c[i] >= 'a' && c[i] <= 'z') || (c[i] - '0' >= 0 && c[i] - '0' <= 9))
        		{
        			st1.add(c[i]);
        			idx++;
        		}
        		else
        		{
        			switch(c[i])
        			{
        			case '<':
        				if(idx - 1 >= 0)
        				{
        					ready.push(st1.pop());
        					idx--;
        				}
        				break;
        			case '>':
        				if(!ready.isEmpty())
        				{
        					st1.push(ready.pop());
        					idx++;
        				}
        				else if(idx < st1.size()) idx++;
        				break;
        			case '-':
        				if(!st1.isEmpty() && idx != 0)
        				{
        					st1.pop();
        					idx--;
        				}
        				break;
        			}
        		}
        	}
        	for(char chr : st1)
        		bw.write(chr);
        	while(!ready.isEmpty())
        		bw.write(ready.pop());
        	if(t < tc - 1)
        		bw.write("\n");
        }
        bw.flush();
    }
}