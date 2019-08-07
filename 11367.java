import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			int score = sc.nextInt();
			
			String grade = getGrade(score);
			System.out.println(name + " " + grade);
		}
	}

	private static String getGrade(int score) {
		if(score >= 97) return "A+";
		if(score >= 90) return "A";
		if(score >= 87) return "B+";
		if(score >= 80) return "B";
		if(score >= 77) return "C+";
		if(score >= 70) return "C";
		if(score >= 67) return "D+";
		if(score >= 60) return "D";
		return "F";
	}
}