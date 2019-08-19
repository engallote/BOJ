import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int[] arr = new int[3];
        	for(int i = 0; i < 3; i++)
        		arr[i] = sc.nextInt();
        	
        	Arrays.sort(arr);
        	System.out.println("Scenario #" + test_case + ":");
        	if((arr[0] * arr[0]) + (arr[1] * arr[1]) == arr[2] * arr[2])
        		System.out.println("yes");
        	else System.out.println("no");
        	System.out.println();
        }
    }
}