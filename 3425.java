import java.util.*;

public class Main {
	static final long max = (long)Math.pow(10, 9);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Long> st = new Stack<>();
		
		while(true)
		{
			String s = sc.next();
			if(s.equals("QUIT")) break;
			else
			{
				Vector<Pair> v = new Vector<>();
				if(!s.equals("END"))
				{
					if(s.equals("NUM"))
					{
						long tmp = sc.nextLong();
						v.add(new Pair(s, tmp));
					}
					else
						v.add(new Pair(s, -1));
					while(true)
					{
						s = sc.next();
						if(s.equals("END")) break;
						if(s.equals("NUM"))
						{
							long tmp = sc.nextLong();
							v.add(new Pair(s, tmp));
						}
						else
							v.add(new Pair(s, -1));
					}
				}
				
				int N = sc.nextInt();
				
				for(int i = 0; i < N; i++)
				{
					st.clear();
					long number = sc.nextLong();
					st.push(number);
					if(number > max)
					{
						System.out.println("ERROR");
						continue;
					}
					boolean flag = true;
					for(int j = 0; j < v.size(); j++)
					{
						Pair p = v.get(j);
						switch(p.str)
						{
						case "NUM":
							st.push(p.num);
							break;
						case "POP":
							if(st.isEmpty())
								flag = false;
							else
								st.pop();
							break;
						case "INV":
							if(st.isEmpty())
								flag = false;
							else
							{
								long n = st.pop();
								st.push(n * -1);
							}
							break;
						case "DUP":
							if(st.isEmpty())
								flag = false;
							else
							{
								long n = st.peek();
								st.push(n);
							}
							break;
						case "SWP":
							if(st.isEmpty() || st.size() == 1)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								st.push(n);
								st.push(n2);
							}
							break;
						case "ADD":
							if(st.isEmpty() || st.size() == 1)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								if(Math.abs(n + n2) > max) flag = false;
								else st.push(n + n2);
							}
							break;
						case "SUB":
							if(st.isEmpty() || st.size() == 1)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								if(Math.abs(n2 - n) > max) flag= false;
								else st.push(n2 - n);
							}
							break;
						case "MUL":
							if(st.isEmpty() || st.size() == 1)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								if(Math.abs(n * n2) > max) flag = false;
								else st.push(n * n2);
							}
							break;
						case "DIV":
							if(st.isEmpty() || st.size() == 1 || st.peek() == 0)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								if(Math.abs(n2 / n) > max) flag = false;
								else st.push(n2 / n);
							}
							break;
						case "MOD":
							if(st.isEmpty() || st.size() == 1 || st.peek() == 0)
								flag = false;
							else
							{
								long n = st.pop(), n2 = st.pop();
								if(Math.abs(n2 % n) > max) flag = false;
								else st.push(n2 % n);
							}
							break;
						}
						if(!flag) break;
					}
					if(!flag || st.size() != 1)
						System.out.println("ERROR");
					else
						System.out.println(st.pop());
				}
				System.out.println();
			}
		}
	}
}
class Pair{
	String str;
	long num;
	Pair(String str, long num){
		this.str = str;
		this.num = num;
	}
}