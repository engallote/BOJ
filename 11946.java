import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Q = sc.nextInt();
		Pair[] arr = new Pair[N+1];
		for(int i = 0; i <= N; i++)
			arr[i] = new Pair(i, 0, 0);
		HashMap<String, Integer> pan = new HashMap<>();
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < Q; i++)
		{
			int time = sc.nextInt();
			int team = sc.nextInt();
			int idx = sc.nextInt();
			String result = sc.next();
			String key = team + "," + idx;
			if(result.equals("AC"))
			{
				if(hs.contains(key)) continue;
				hs.add(key);
				if(pan.containsKey(key))//여러 번 시도 끝에 맞췄다
				{
					int panalty = pan.get(key) * 20;
					arr[team].ac += 1;
					arr[team].time += time + panalty;
					pan.remove(key);
				}
				else//한 번에 맞췄다
				{
					arr[team].ac += 1;
					arr[team].time += time;
				}
			}
			else
			{
				if(pan.containsKey(key))
				{
					int value = pan.get(key) + 1;
					pan.remove(key);
					pan.put(key, value);
				}
				else pan.put(key, 1);
			}
		}
		Arrays.sort(arr);
		for(int i = 0; i <= N; i++)
		{
			if(arr[i].idx == 0) continue;
			System.out.println(arr[i].idx + " " + arr[i].ac + " " + arr[i].time);
		}
	}
}
class Pair implements Comparable<Pair>{
	int idx, ac, time;
	Pair(int idx, int ac, int time)
	{
		this.idx = idx;
		this.ac = ac;
		this.time = time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.ac > this.ac) return 1;
		else if(o.ac == this.ac)
		{
			if(o.time > this.time) return -1;
			else if(o.time == this.time)
			{
				if(o.idx > this.idx) return -1;
				else return 1;
			}
			else return 1;
		}
		else return -1;
	}
}