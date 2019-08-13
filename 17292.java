import java.util.*;

public class Main {
	static String[] str;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = new int[104];
		for(char c = '1'; c <= '9'; c++)
			number[c] = c-'0';
		for(char c = 'a'; c <= 'f'; c++)
			number[c] = c - 'a' + 10;
		str = sc.next().split(",");
		for(int i = 0; i < 6; i++)
		{
			for(int j = i + 1; j < 6; j++)
			{
				int num1 = number[str[i].charAt(0)], num2 = number[str[j].charAt(0)];
				pq.add(new Pair(num1, str[i].charAt(1), num2, str[j].charAt(1)));
			}
		}
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			if(p.n1 < 10) System.out.print(p.n1);
			else System.out.print((char)(p.n1 - 10 + 'a'));
			System.out.print(p.c1);
			if(p.n2 < 10) System.out.print(p.n2);
			else System.out.print((char)(p.n2 - 10 + 'a'));
			System.out.print(p.c2);
			System.out.println();
		}
	}
}
class Pair implements Comparable<Pair>{
	char c1, c2;
	int n1, n2;
	Pair(int n1, char c1, int n2, char c2)
	{
		this.n1 = n1;
		this.c1 = c1;
		this.n2 = n2;
		this.c2 = c2;
	}
	@Override
	public int compareTo(Pair o) {
		int abs1 = Math.abs(o.n1 - o.n2), abs2 = Math.abs(this.n1 - this.n2);
		if((abs1 == 1 || abs1 == 14) && (abs2 != 1 && abs2 != 14)) return 1;
		else if((abs1 != 1 && abs1 != 14) && (abs2 == 1 || abs2 == 14)) return -1;
		else if(o.n1 == o.n2 && this.n1 != this.n2) return 1;
		else if(o.n1 != o.n2 && this.n1 == this.n2) return -1;
		else
		{
			if(o.c1 == o.c2 && this.c1 != this.c2) return 1;
			else if(o.c1 != o.c2 && this.c1 == this.c2) return -1;
			else if(Math.max(o.n1, o.n2) > Math.max(this.n1, this.n2)) return 1;
			else if(Math.max(o.n1, o.n2) < Math.max(this.n1, this.n2)) return -1;
			else if(Math.min(o.n1, o.n2) > Math.min(this.n1, this.n2)) return 1;
			else if(Math.min(o.n1, o.n2) < Math.min(this.n1, this.n2)) return -1;
			else
			{
				char color1 = ' ', color2 = ' ';
				if(o.n1 > o.n2) color1 = o.c1;
				else color1 = o.c2;
				if(this.n1 > this.n2) color2 = this.c1;
				else color2 = this.c2;
				if(color1 == 'b' && color2 != 'b') return 1;
				else return -1;
			}
		}
	}
}