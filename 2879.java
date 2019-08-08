import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N], arr2 = new int[N], state = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			arr2[i] = sc.nextInt();
			if(arr[i] > arr2[i]) state[i] = -1;
			else if(arr[i] < arr2[i]) state[i] = 1;
		}
		int res = 0;
		while(true)
		{
			int pre = 10, start = 0;
			for(int i = 0; i < N; i++)
			{
				if(state[i] == pre) continue;
				else
				{
					if(pre != 10)
					{
						boolean flag = true;
						while(flag)
						{
							res++;
							for(int j = start; j < i; j++)
							{
								if(state[j] == 1)
								{
									arr[j]++;
									if(arr[j] == arr2[j]) 
									{
										state[j] = 0;
										flag = false;
									}
								}
								else if(state[j] == -1)
								{
									arr[j]--;
									if(arr[j] == arr2[j])
									{
										state[j] = 0;
										flag = false;
									}
								}
//								System.out.println(">> " + j + " : " + arr[j] + " " + arr2[j]);
							}
//							System.out.println("--------");
						}
					}
					if(state[i] == 0)
					{
						pre = 10;
						continue;
					}
					start = i;
					pre = state[i];
				}
			}
			if(pre != 10)
			{
				boolean flag = true;
				while(flag)
				{
					res++;
					for(int j = start; j < N; j++)
					{
						if(state[j] == 1)
						{
							arr[j]++;
							if(arr[j] == arr2[j]) 
							{
								state[j] = 0;
								flag = false;
							}
						}
						else if(state[j] == -1)
						{
							arr[j]--;
							if(arr[j] == arr2[j])
							{
								state[j] = 0;
								flag = false;
							}
						}
					}
				}
			}
			boolean end = true;
			for(int i = 0; i < N; i++)
			{
				if(state[i] != 0) end = false;
//				System.out.print(arr[i] + " ");
			}
//			System.out.println();
			if(end) break;
		}
		System.out.println(res);
	}
}