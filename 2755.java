import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		double res = 0, s = 0;
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			String grade = st.nextToken();
			s += score;
			double sum = score;
			switch(grade)
			{
			case "A+": sum *= 4.3; break;
			case "A0": sum *= 4.0; break;
			case "A-": sum *= 3.7; break;
			case "B+": sum *= 3.3; break;
			case "B0": sum *= 3.0; break;
			case "B-": sum *= 2.7; break;
			case "C+": sum *= 2.3; break;
			case "C0": sum *= 2.0; break;
			case "C-": sum *= 1.7; break;
			case "D+": sum *= 1.3; break;
			case "D0": sum *= 1.0; break;
			case "D-": sum *= 0.7; break;
			case "F" : sum *= 0; break;
			}
			res += sum;
		}
		
		System.out.printf("%.2f", (res / s));
	}
}