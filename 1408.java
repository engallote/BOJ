import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split(":");
		String[] b = sc.next().split(":");
		int[] now = {Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2])};
		int[] start = {Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2])};
		int h = 0, m = 0, s = 0;
		
		s = 60 - now[2] + start[2];
		if(now[2] > start[2])//지금 초가 시작 초보다 높을 경우
			now[1]++;//1분 증가
		
		m = 60 - now[1] + start[1];
		
		if(now[1] > start[1])//지금 분이 시작 분보다 높을 경우
		{
			if(now[0] < start[0])
				h = start[0] - (now[0] + 1);
			else if(now[0] == start[0])
				h = 23;
			else
				h = 24 - (now[0] - start[0] + 1);
		}
		else if(now[1] < start[1])//지금 분이 시작 분보다 낮을 경우
		{
			if(now[0] < start[0])
				h = start[0] - now[0];
			else if(now[0] == start[0])
				h = 0;
			else
				h = 24 - (now[0] - start[0]);
		}
		else//분이 같을 경우
		{
			if(now[0] < start[0])
				h = start[0] - now[0];
			else if(now[0] == start[0])
				h = 0;
			else
				h = 24 - (now[0] - start[0]);
		}
		
		if(h >= 24)
			h -= 24;
		if(m >= 60)
			m -= 60;
		if(s >= 60)
			s -= 60;
		
		StringBuilder str = new StringBuilder();
		if(Integer.toString(h).length() == 1)
			str.append("0"+h+":");
		else
			str.append(h+":");
		if(Integer.toString(m).length() == 1)
			str.append("0"+m+":");
		else
			str.append(m+":");
		if(Integer.toString(s).length() == 1)
			str.append("0"+s);
		else
			str.append(s);
		System.out.println(str);
	}
}