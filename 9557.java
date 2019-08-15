import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			ArrayList<String> arr = new ArrayList<>();
			int idx = -1;//기준점
			for(int i = 0; i < N; i++)
			{
				String str = sc.next();
				arr.add(str);
				if(!str.contains("#")) idx = i;
			}
			
			if(idx == -1)
				for(String str : arr) System.out.print(str + " ");
			else
			{
				for(int i = idx + 1; i < N; i++) System.out.print(arr.get(i) + " ");
				System.out.print(arr.get(idx) + " ");
				for(int i = 0; i < idx; i++) System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
	}
}