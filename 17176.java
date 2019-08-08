import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		sc.nextLine();
		char[] c = sc.nextLine().toCharArray();
		int num = 0;
		int[] alp = new int[200];
		HashSet<Integer> hs = new HashSet<>();
		boolean flag = true;
		for(int i = 0; i < N; i++)
		{
			if(c[i] >= 'A' && c[i] <= 'Z')
			{
				num = c[i] - 'A' + 1;
				alp[num]++;
			}
			else if(c[i] >= 'a' && c[i] <= 'z')
			{
				num = c[i] - 'a' + 27;
				alp[num]++;
			}
			else if(c[i] == ' ')
			{
				alp[0]++;
			}
		}
		
		for(int i = 0; i < N; i++)
			alp[arr[i]]--;
		Arrays.sort(alp);
		if(alp[199] != 0 || alp[0] != 0) flag = false;
		
		if(flag) System.out.println("y");
		else System.out.println("n");
	}
}