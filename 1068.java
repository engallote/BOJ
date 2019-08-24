import java.util.*;

public class Main {
	static int N, d, cnt = 0, cnt2 = 0;
	static ArrayList<ArrayList<Integer>> aly = new ArrayList<>();
	static HashSet<Integer> hs = new HashSet<>();
	static int[] arr;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visit = new boolean[N];
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			aly.add(new ArrayList<>());
		int root = 0;
		for(int i = 0; i < N; i++)
		{
			int n = sc.nextInt();
			arr[i] = n;
			if(n == -1)
			{
				root = i;
				continue;
			}
			aly.get(n).add(i);
		}
		boolean f = true;
		for(int i = 1; i < N; i++)
			if(Math.abs(Math.abs(arr[i-1]) - Math.abs(arr[i])) != 1)
				f = false;
			
		d = sc.nextInt();//삭제할 노드

		if(f)//직선 트리인 경우
		{
			if(root == d)
				System.out.println(0);
			else
				System.out.println(1);
			return;
		}
		if(root == d)//루트가 삭제할 노드일 경우
		{
			System.out.println(0);
			return;
		}
		f = false;
		if(aly.get(d).size() == 0)//리프노드를 삭제할 경우
			f = true;
		
		if(f)//리프노드가 속한 부모에게서 리프 노드 삭제
		{
			for(int i = 0; i < aly.get(arr[d]).size(); i++)
				if(aly.get(arr[d]).get(i) == d)
				{
					aly.get(arr[d]).remove(i);
					break;
				}
		}
		visit[root] = true;
		leafNodeFind(root);
		cnt = hs.size();
		hs.clear();
		
		if(!f)
		{
			Arrays.fill(visit, false);
			visit[d] = true;
			remove(d);
			cnt2 = hs.size();
		}
		
//		System.out.println("cnt : " + cnt + ", cnt2 : "+ cnt2);
		System.out.println(cnt - cnt2);
	}
	private static void leafNodeFind(int root) {
		if(aly.get(root).size() == 0)
		{
			hs.add(root);
		}
		else
		{
			for(int i = 0; i < aly.get(root).size(); i++)
			{
				int n = aly.get(root).get(i);
				if(!visit[n])
				{
					visit[n] = true;
					leafNodeFind(n);
				}
			}
		}
	}
	private static void remove(int root) {
		if(aly.get(root).size() == 0)
		{
			hs.add(root);
		}
		else
		{
			for(int i = 0; i < aly.get(root).size(); i++)
			{
				int n = aly.get(root).get(i);
				if(!visit[n])
				{
					visit[n] = true;
					leafNodeFind(n);
				}
			}
		}
	}
}