import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int res = 0;
			for(int i = 0; i < 7; i++)
			{
				int num = sc.nextInt();
				switch(i){
				case 0: res += Math.abs(9.23076 * Math.pow((26.7 - num), 1.835)); break;
				case 1: res += Math.abs(1.84523 * Math.pow((num - 75), 1.348)); break;
				case 2: res += Math.abs(56.0211 * Math.pow(num - 1.5, 1.05)); break;
				case 3: res += Math.abs(4.99087 * Math.pow(42.5 - num, 1.81)); break;
				case 4: res += Math.abs(0.188807 * Math.pow(num - 210, 1.41)); break;
				case 5: res += Math.abs(15.9803 * Math.pow(num - 3.8, 1.04)); break;
				case 6: res += Math.abs(0.11193 * Math.pow(254 - num, 1.88)); break;
				}
			}
			
			System.out.println(res);
		}
	}
}