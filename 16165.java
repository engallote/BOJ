import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] str = new String[N];
		ArrayList<String>[] arr = new ArrayList[N];
		HashMap<String, Integer> hs = new HashMap<>();
		for(int i = 0; i < N; i++)
		{
			String group = sc.next();
			str[i] = group;
			arr[i] = new ArrayList<>();
			hs.put(group, i);
			int number = sc.nextInt();
			
			for(int j = 0; j < number; j++)
			{
				String name = sc.next();
				arr[i].add(name);
			}
		}
		
		for(int i = 0; i < M; i++)
		{
			String s = sc.next();
			int num = sc.nextInt();
			
			if(num == 0)//팀 멤버 이름 사전순으로 출력
			{
				int idx = hs.get(s);
				Collections.sort(arr[idx]);
				
				for(String name : arr[idx])
					System.out.println(name);
			}
			else//속한 팀 이름 출력
			{
				for(int k = 0; k < N; k++)
					if(arr[k].contains(s))
					{
						System.out.println(str[k]);
						break;
					}
			}
		}
	}
}