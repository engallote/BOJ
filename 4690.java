import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[101];
		arr[1] = 1;
		for(int i = 2; i <= 100; i++)
			arr[i] = (int)Math.pow(i, 3);
		boolean[] visit = new boolean[101];
		for(int i = 2; i <= 100; i++)
		{
			Arrays.fill(visit, false);
			for(int j = 2; j <= 100; j++)
				for(int k = 2; k <= 100; k++)
					for(int l = 2; l <= 100; l++)
						if(!visit[j] || !visit[k] || !visit[l])
							if(arr[i] == arr[j] + arr[k] + arr[l])
							{
								visit[j] = visit[k] = visit[l] = true;
								System.out.println("Cube = " + i + ", Triple = (" + j+","+k+","+l+")");
								break;
							}
		}
	}
}