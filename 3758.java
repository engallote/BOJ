import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();//팀의 개수
			int K = sc.nextInt();//문제 개수
			int t = sc.nextInt();//우리 팀 아이디
			int M = sc.nextInt();//엔트리 개수
			Pair[] arr = new Pair[N];
			int[][] scoreTable = new int[N][K+1];
			for(int i = 0; i < N; i++)
				arr[i] = new Pair(i + 1, 0, 0, 0);
			
			for(int i = 0; i < M; i++)
			{
				int id = sc.nextInt();//제출한 팀
				int num = sc.nextInt();//문제 번호
				int score = sc.nextInt();//획득한 점수
				
				arr[id-1].cnt += 1;
				arr[id-1].last_time = i;
				scoreTable[id-1][num] = Math.max(scoreTable[id-1][num], score);
			}
			
			for(int i = 0; i < N; i++)
				for(int j = 1; j <= K; j++)
					arr[i].score += scoreTable[i][j];
			
			Arrays.sort(arr);
			
			for(int i = 0; i < N; i++)
				if(arr[i].id == t)
				{
					System.out.println(i+1);
					break;
				}
		}
	}
}
class Pair implements Comparable<Pair>{
	int id, score, cnt, last_time;
	Pair(int id, int score, int cnt, int last_time)
	{
		this.id = id;
		this.score = score;
		this.cnt = cnt;
		this.last_time = last_time;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.score > this.score) return 1;
		else if(o.score == this.score)
		{
			if(o.cnt > this.cnt) return -1;
			else if(o.cnt == this.cnt)
			{
				if(o.last_time > this.last_time) return -1;
				else return 1;
			}
			else return 1;
		}
		else return -1;
	}
}