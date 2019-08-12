import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[9];
		int max = 0, idx = 0;
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < N; j++)
				arr[i] = Math.max(arr[i], sc.nextInt());
			if(max < arr[i])
			{
				max = arr[i];
				idx = i;
			}
		}
		
		switch(idx){
		case 0 : System.out.println("PROBRAIN"); break;
		case 1 : System.out.println("GROW"); break;
		case 2 : System.out.println("ARGOS"); break;
		case 3 : System.out.println("ADMIN"); break;
		case 4 : System.out.println("ANT"); break;
		case 5 : System.out.println("MOTION"); break;
		case 6 : System.out.println("SPG"); break;
		case 7 : System.out.println("COMON"); break;
		case 8 : System.out.println("ALMIGHTY"); break;
		}
	}
}