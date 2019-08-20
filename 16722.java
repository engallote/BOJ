import java.util.*;

public class Main {
	static Shape[] arr;
	static HashSet<Integer> all = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new Shape[10];
        int res = 0;
        HashMap<String, Integer> color = new HashMap<>();
        color.put("RED", 0);
        color.put("YELLOW", 1);
        color.put("BLUE", 2);
        color.put("BLACK", 3);
        color.put("GRAY", 4);
        color.put("WHITE", 5);
		for(int i = 1; i <= 9; i++)
		{
			char s = sc.next().charAt(0);
			String c = sc.next();
			String b = sc.next();
			arr[i] = new Shape(s, color.get(c), color.get(b));
		}
		
		for(int k = 1; k <= 9; k++)
			for(int i = k + 1; i <= 9; i++)
				for(int j = i + 1; j <= 9; j++)
				{
					int where = -1;
					//���, ����, �� ��� ����. OOO
					if((arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b))
					{
						where = 0;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ���� ���� ����� ��� �ٸ���. OOX
					else if((arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b))
					{
						where = 1;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ����� ���� ���� ��� �ٸ���. OXO
					else if((arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b))
					{
						where = 2;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ���� ���� ����� ��� �ٸ���. OXX
					else if((arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b))
					{
						where = 3;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ��� �ٸ��� ���� ����� ����. XOO
					else if((arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b))
					{
						where = 4;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ����� ��� �ٸ��� ���� ����. XOX
					else if((arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b))
					{
						where = 5;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//������ ���� �ٸ��� ����� ����. XXO
					else if((arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b))
					{
						where = 6;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					//����, ��, ����� ��� �ٸ���. XXX
					else if((arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b))
					{
						where = 7;
//						System.out.println(k*100+i*10+j);
						all.add(k*100+i*10+j);
					}
					else continue;
//					System.out.println(k*100+i*10+j);
//					System.out.println(where);
//					System.out.println(arr[k].s + " " + arr[i].s + " " + arr[j].s);
//					System.out.println(arr[k].c + " " + arr[i].c + " " + arr[j].c);
//					System.out.println(arr[k].b + " " + arr[i].b + " " + arr[j].b);
//					System.out.println("-------------------------");
				}
				
		
		int N = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		boolean g = false;
		for(int ii = 0; ii < N; ii++)
		{
			char c = sc.next().charAt(0);
			if(c == 'H')
			{
				int[] num = new int[3];
				for(int j = 0; j < 3; j++)
					num[j] = sc.nextInt();
				Arrays.sort(num);
				int k = num[0];
				int i = num[1];
				int j = num[2];
				if((arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b) || 
					(arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b)|| 
					(arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b) ||
					(arr[k].s == arr[i].s && arr[i].s == arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b) ||
					(arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b) ||
					(arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c == arr[i].c && arr[i].c == arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b) ||
					(arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b == arr[i].b && arr[i].b == arr[j].b) ||
					(arr[k].s != arr[i].s && arr[i].s != arr[j].s && arr[k].s != arr[j].s) && (arr[k].c != arr[i].c && arr[i].c != arr[j].c && arr[k].c != arr[j].c) && (arr[k].b != arr[i].b && arr[i].b != arr[j].b && arr[k].b != arr[j].b))
				{
					int sum = num[0] * 100 + num[1] * 10 + num[2];
//					System.out.println(sum);
					if(hs.contains(sum))
					{
//						System.out.println("�ִ� - > " + (res-1));
						res--;
					}
					else
					{
//						System.out.println("input");
						hs.add(sum);
						res++;
//						System.out.println(">> " + res);
					}
				}
				else res--;
			}
			else
			{
				if(hs.size() == all.size() && !g)
				{
//					System.out.println("GG");
					g = true;
					res += 3;
				}
				else
				{
//					System.out.println("���� �θ��� ���� ���� �����ִ�");
					res--;
				}
			}
		}
		System.out.println(res);
    }
}
class Shape{
	char s;
	int c, b;
	Shape(char s, int c, int b)
	{
		this.s = s;
		this.c = c;
		this.b = b;
	}
}