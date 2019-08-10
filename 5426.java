import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, String> hs = new HashMap<>();
		
		for(int i = 0; i < N; i++)
		{
			int x = sc.nextInt();
			int c = sc.nextInt();
			if(hs.containsKey(c))
			{
				String value = hs.get(c) + x + " ";
				hs.remove(c);
				hs.put(c, value);
			}
			else
				hs.put(c, x+" ");
		}

		Iterator<Integer> it = hs.keySet().iterator();
		long sum = 0;
		while(it.hasNext())
		{
			String s = hs.get(it.next());
			s = s.trim();
//			System.out.println(s);
			String[] tmp = s.split(" ");
			int[] arr = new int[tmp.length];
			
			for(int i = 0; i < tmp.length; i++)
				arr[i] = Integer.parseInt(tmp[i]);
			Arrays.sort(arr);
			sum += arr[1] - arr[0];
			for(int i = 1; i < arr.length-1; i++)
			{
				if(arr[i] - arr[i-1] > arr[i+1] - arr[i])
					sum += arr[i+1] - arr[i];
				else
					sum += arr[i] - arr[i-1];
			}
			sum += arr[arr.length-1] - arr[arr.length-2];
		}
		System.out.println(sum);
	}
}