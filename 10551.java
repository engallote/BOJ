import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.next().toCharArray();
		int len = c.length;
		int[] finger = new int[8];
		for(int i = 0; i < len; i++)
			finger[find(c[i])]++;
		for(int i = 0; i < 8; i++)
			System.out.println(finger[i]);
	}

	private static int find(char c) {
		if(c == 'A' || c == 'Q' || c == 'Z' || c == '1') return 0;
		else if(c == '2' || c == 'W' || c == 'S' || c == 'X') return 1;
		else if(c == '3' || c == 'E' || c == 'D' || c == 'C') return 2;
		else if(c == '4' || c == '5' || c == 'R' || c == 'T' || c == 'F' || c == 'G'
				|| c == 'V' || c == 'B') return 3;
		else if(c == '6' || c == '7' || c == 'Y' || c == 'U' || c == 'H' || c == 'J'
				|| c == 'N' || c == 'M') return 4;
		else if(c == '8' || c == 'I' || c == 'K' || c == ',') return 5;
		else if(c == '9' || c == 'O' || c == 'L' || c == '.') return 6;
		else return 7;
//		else if(c == '0' || c == '-' || c == '=' || c == 'P' || c == '[' || c == ']'
//				|| c == ';' || c == '\'' || c == '/') return 7;
		
	}
}