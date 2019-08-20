import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        
        int[] arr = new int[1000];
        
        for(int i = 1; i < 1000; i+=(A+B))
        {
        	for(int j = i; j < i + A; j++)
        		if(j < 1000)
        			arr[j]++;
        }
        for(int i = 1; i < 1000; i+=(C+D))
        {
        	for(int j = i; j < i + C; j++)
        		if(j < 1000)
        			arr[j]++;
        }
//        for(int i = 1; i < 1000; i++)
//        	System.out.println(i + " : " + arr[i]);
        
        int P = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        System.out.println(arr[P]);
        System.out.println(arr[M]);
        System.out.println(arr[N]);
    }
}