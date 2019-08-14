import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		Queue<Pair>[] q = new LinkedList[M+1];
		Queue<Pair> tmp = new LinkedList<Pair>();
		PriorityQueue<Pair>[][] arr = new PriorityQueue[N + 1][M + 1];
		for(int i = 1; i <= M; i++)
			q[i] = new LinkedList<Pair>();
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++)
				arr[i][j] = new PriorityQueue<>();
		
		
		for(int i = 0; i < S; i++)
		{
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			int z = sc.nextInt();
			q[c].offer(new Pair(i, r, c, s, d, z));
		}
		
		int size = 0, res = 0;
		for(int i = 1; i <= M; i++)//오른쪽으로 이동
		{
			size = q[i].size();
			while(size > 0)
			{
				Pair p = q[i].poll();
				
				if(tmp.isEmpty()) tmp.offer(p);
				else
				{
					if(tmp.peek().r < p.r) q[i].offer(p);
					else
					{
						q[i].offer(tmp.poll());
						tmp.offer(p);
					}
				}
				size--;
			}
			
			if(!tmp.isEmpty())
				res += tmp.poll().z;//잡은 상어 크기 더하기
			
			//상어 이동
			for(int j = 1; j <= M; j++)
				if(!q[j].isEmpty())
				{
					size = q[j].size();
					while(size > 0)
					{
						Pair p = q[j].poll();
						
						if(p.s == 0)//속도 없음
							arr[p.r][p.c].offer(p);
						else
						{
							int speed = p.s, r = p.r, c = p.c, d = p.d;
							if(d == 1 || d == 2)
							{
								while(speed > 0)
								{
									if(d == 1)
									{
										if(speed >= r - 1)
										{
											speed -= r - 1;
											r = 1;
											d = 2;
										}
										else
										{
											r -= speed;
											break;
										}
									}
									else
									{
										if(speed >= N - r)
										{
											speed -= N - r;
											r = N;
											d = 1;
										}
										else
										{
											r += speed;
											break;
										}
									}
								}
							}
							else
							{
								while(speed > 0)
								{
									if(d == 4)
									{
										if(speed >= c - 1)
										{
											speed -= c - 1;
											c = 1;
											d = 3;
										}
										else
										{
											c -= speed;
											break;
										}
									}
									else
									{
										if(speed >= M - c)
										{
											speed -= M - c;
											c = M;
											d = 4;
										}
										else
										{
											c += speed;
											break;
										}
									}
								}
							}
							arr[r][c].add(new Pair(p.idx, r, c, p.s, d, p.z));
						}
						size--;
					}//while
				}
			
			//상어 겹치는 애들끼리 잡아먹기
			for(int k = 1; k <= N; k++)
			{
				for(int j = 1; j <= M; j++)
				{
					if(arr[k][j].isEmpty()) continue;
					
					q[j].offer(arr[k][j].poll());
					arr[k][j].clear();
				}
			}
		}
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int idx, r, c, s, d, z;
	Pair(int idx, int r, int c, int s, int d, int z){
		this.idx = idx;
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.z > this.z) return 1;
		else if(o.z == this.z) return 0;
		return -1;
	}
}
