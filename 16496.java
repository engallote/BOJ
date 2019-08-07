import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Pair>[] arr = new ArrayList[10];
		for(int i = 0; i < 10; i++)
			arr[i] = new ArrayList<>();
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			char c = Integer.toString(num).charAt(0);
			
			arr[c-'0'].add(new Pair(num));
		}
		
		for(int i = 0; i < 10; i++)
			Collections.sort(arr[i]);
		
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 9; i >= 0; i--)
			for(int j = 0; j < arr[i].size(); j++)
			{
				sb.append(arr[i].get(j).num);
				hs.add(arr[i].get(j).num);
			}
		
		if(hs.size() == 1 && hs.contains(0)) System.out.println(0);
		else System.out.println(sb.toString());
	}
}
class Pair implements Comparable<Pair>{
	int num;
	Pair(int num){this.num = num;}
	@Override
	public int compareTo(Pair o) {
		char[] a = Integer.toString(o.num).toCharArray();
		char[] b = Integer.toString(this.num).toCharArray();
		
		for(int i = 0; i < Math.min(a.length, b.length); i++)
		{
			if(a[i] > b[i]) return 1;
			else if(a[i] < b[i]) return -1;
		}
		if(a[a.length - 1] < b[b.length - 1]) return -1;
		else if(a[a.length - 1] == b[b.length - 1]) return 0;
		else return 1;
	}
}