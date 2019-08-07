import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		HashMap<String, String> hs = new HashMap<>();
		hs.put(".-", "A");
		hs.put("-...", "B");
		hs.put("-.-.", "C");
		hs.put("-..", "D");
		hs.put(".", "E");
		hs.put("..-.", "F");
		hs.put("--.", "G");
		hs.put("....", "H");
		hs.put("..", "I");
		hs.put(".---", "J");
		hs.put("-.-", "K");
		hs.put(".-..", "L");
		hs.put("--", "M");
		hs.put("-.", "N");
		hs.put("---", "O");
		hs.put(".--.", "P");
		hs.put("--.-", "Q");
		hs.put(".-.", "R");
		hs.put("...", "S");
		hs.put("-", "T");
		hs.put("..-", "U");
		hs.put("...-", "V");
		hs.put(".--", "W");
		hs.put("-..-", "X");
		hs.put("-.--", "Y");
		hs.put("--..", "Z");
		for(int i = 1; i <= N; i++)
		{
			String[] str = sc.nextLine().split(" ");
			System.out.print("Case " + i + ": ");
			for(int j = 0; j < str.length; j++)
				System.out.print(hs.get(str[j]));
			System.out.println();
		}
	}
}