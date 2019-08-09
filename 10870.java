import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int  N = sc.nextInt();
		int[] arr = new int[21];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i = 3; i <= N; i++)
			arr[i] = arr[i-1] + arr[i-2];
		
		System.out.println(arr[N]);
	} 
}