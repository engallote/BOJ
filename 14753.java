import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] plus = new int[N], minus = new int[N];
		int res = 0;
		int idx1 = 0, idx2 = 0;
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(num == 0) continue;
			else if(num > 0) plus[idx1++] = num;
			else minus[idx2++] = num;
		}
		Arrays.sort(plus);
		Arrays.sort(minus);
		if(idx2 > 1)//음수가 두 개 이상
		{
			int tmp = minus[0] * minus[1];
			res = tmp;
			res = Math.max(res, tmp * plus[N-1]);
		}
		int ret = 1;
		for(int i = N - 1, cnt = 1; i >= 0 && cnt <= 3; i--, cnt++)
		{
			ret *= plus[i];
			if(cnt >= 2) res = Math.max(ret, res);
		}
		System.out.println(res);
	}
}