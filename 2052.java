import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal bg = new BigDecimal("1");
		BigDecimal res = BigDecimal.ONE;
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			bg = bg.multiply(new BigDecimal("2"));
		res = res.divide(bg);
		if(res.toString().contains("-"))
		{
			int idx = res.toString().indexOf("-");
			String num = "";
			for(int i = idx + 1; i < res.toString().length(); i++)
			{
				if(res.toString().charAt(i) >= '0' && res.toString().charAt(i) <= '9')
					num += res.toString().charAt(i)+"";
				else break;
			}
			
			int end = Integer.parseInt(num);
			for(int i = 0; i < end; i++)
			{
				if(i == 0)
					System.out.print("0.");
				else
					System.out.print("0");
			}
			StringBuilder str = new StringBuilder();
			for(int i = idx - 2; i >= 0; i--)
			{
				if((str.length() == 0 && res.toString().charAt(i) == '0') || res.toString().charAt(i) == '.') continue;
				else
					str.append(res.toString().charAt(i));
			}
			str.reverse();
			System.out.println(str.toString());
		}
		else
			System.out.println(res.toString());
	}
}