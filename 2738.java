import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] a = new int[N][M], b = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				a[i][j] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				b[i][j] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
				System.out.print((a[i][j] + b[i][j]) + " ");
			System.out.println();
		}
	} 
}