import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 0; t < tc; t++)
        {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	int gap = 0, min = 0, max = 0;
        	for(int i = 0; i < N; i++)
        		arr[i] = sc.nextInt();
        	
        	Arrays.sort(arr);
        	
        	for(int i = 1; i < N; i++)
        		gap = Math.max(gap, arr[i] - arr[i-1]);
        	max = arr[N-1];
        	min = arr[0];
        	System.out.println("Class " + (t+1));
        	System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
        }
    }
}