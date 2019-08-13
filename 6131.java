import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] arr = new boolean[250001];
		
		for(int i = 1; i <= 500; i++)
			arr[i * i] = true;
		int res = 0;
		for(int i = 1; i <= 250000; i++)
			if(arr[i] && i + N <= 250000 && arr[i + N]) res++;
		System.out.println(res);
	}
}