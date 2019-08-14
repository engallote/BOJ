import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = N; i >= 0; i--)
		{
			if(i == 0)
			{
				if(N > 1)
					System.out.printf("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, %d bottles of beer on the wall.\n", N);
				else
					System.out.printf("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, %d bottle of beer on the wall.\n", N);
			}
			else if(i == 1)
			{
				System.out.printf("%d bottle of beer on the wall, %d bottle of beer.\nTake one down and pass it around, no more bottles of beer on the wall.\n", i, i);
				System.out.println();
			}
			else if(i == 2)
			{
				System.out.printf("%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottle of beer on the wall.\n", i, i, i-1);
				System.out.println();
			}
			else
			{
				System.out.printf("%d bottles of beer on the wall, %d bottles of beer.\nTake one down and pass it around, %d bottles of beer on the wall.\n", i, i, i-1);
				System.out.println();
			}
		}
	}
}