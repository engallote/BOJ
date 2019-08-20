import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Vector<Integer> v = new Vector<>();
        for(int i = 0; i < N; i++)
        	v.add(Integer.parseInt(st.nextToken()));
        
        v.sort(null);
        System.out.println(v.get(M-1));
    }
}