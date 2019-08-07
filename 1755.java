import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = M; i <= N; i++)
		{
			int num = i;
			StringBuilder sb = new StringBuilder();
			while(num > 0)
			{
				sb.append(num % 10 + " ");
				num /= 10;
			}
			sb.reverse();
			String[] str = sb.toString().trim().split(" ");
			String s = "";
			for(int k = 0; k < str.length; k++)
				s += number[Integer.parseInt(str[k])] + " ";
			s.trim();
			pq.add(s);
		}
		
		while(!pq.isEmpty())
		{
			for(int i = 0; i < 10 && !pq.isEmpty(); i++)
			{
				String num = "";
				String[] str = pq.poll().split(" ");
				
				for(int k = 0; k < str.length; k++)
				{
					switch(str[k]){
					case "zero" : num += "0"; break;
					case "one" : num += "1"; break;
					case "two" : num += "2"; break;
					case "three" : num += "3"; break;
					case "four" : num += "4"; break;
					case "five" : num += "5"; break;
					case "six" : num += "6"; break;
					case "seven" : num += "7"; break;
					case "eight" : num += "8"; break;
					case "nine" : num += "9"; break;
					}
				}
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}