import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int res = 0;
		for(int yeong = 1; yeong <= N; yeong++)
			for(int teack = 2; teack <= N; teack+=2)
				for(int nam = yeong + 2; nam <= N; nam++)
					if(nam >= yeong + 2 && teack % 2 == 0 && nam + yeong + teack == N) res++;
					
		System.out.println(res);
	}
}