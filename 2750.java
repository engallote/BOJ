import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		
		n = sc.nextInt();
		int[] a = new int[n];
		
		if((1<=n)&&(n<=1000))
		{
			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextInt();
			}
			
			for(int j=1; j <n; j++)
			{
				for(int i=0; i < n-1; i++)
				{
					if(a[i] >= a[j])
					{
						int s = a[i];
						a[i] = a[j];
						a[j] = s;
					}
				}
			}
			
			for(int i = 0; i < n; i++)
			{
				System.out.println(a[i]);
			}
		}
		else
		{
			System.out.println("1�̻� 1000������ ���ڸ� �Է����ּ���.");
		}
	}
}