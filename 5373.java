import java.util.*;

public class Main {
	static char[][] cubeUp, cubeDown, cubeLeft, cubeRight, cubeBack, cubeFront;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int test_case = 1; test_case <= tc; test_case++)
        {
        	int N = sc.nextInt();
        	cubeUp = new char[3][3];
        	cubeDown = new char[3][3];
        	cubeLeft = new char[3][3];
        	cubeRight = new char[3][3];
        	cubeBack = new char[3][3];
        	cubeFront = new char[3][3];
        	
        	for(int i = 0; i < 3; i++)
        	{
        		Arrays.fill(cubeUp[i], 'w');
        		Arrays.fill(cubeDown[i], 'y');
        		Arrays.fill(cubeFront[i], 'r');
        		Arrays.fill(cubeBack[i], 'o');
        		Arrays.fill(cubeLeft[i], 'g');
        		Arrays.fill(cubeRight[i], 'b');
        	}
        	
        	for(int k = 0; k < N; k++)
        	{
        		char[] c = sc.next().toCharArray();
        		switch(c[0]){
        		case 'L':
        			if(c[1] == '+')//시계방향
        				rotateLeft(1);
        			else//반시계방향
        				rotateLeft(0);
        			break;
        		case 'R':
        			if(c[1] == '+')
        				rotateRight(1);
        			else
        				rotateRight(0);
        			break;
        		case 'B':
        			if(c[1] == '+')
        				rotateBack(1);
        			else
        				rotateBack(0);
        			break;
        		case 'F':
        			if(c[1] == '+')
        				rotateFront(1);
        			else
        				rotateFront(0);
        			break;
        		case 'D':
        			if(c[1] == '+')
        				rotateDown(1);
        			else
        				rotateDown(0);
        			break;
        		case 'U':
        			if(c[1] == '+')
        				rotateUp(1);
        			else
        				rotateUp(0);
        			break;
        		}
        	}
        	
        	for(int i = 0; i < 3; i++)
        	{
        		for(int j = 0; j < 3; j++)
        			System.out.print(cubeUp[i][j]);
        		System.out.println();
        	}
        }
    }
	private static void rotateLeft(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeUp[0][0];
		tmp[1] = cubeUp[1][0];
		tmp[2] = cubeUp[2][0];
		if(d == 1)//시계방향
		{
			cubeUp[0][0] = cubeBack[2][2];
			cubeUp[1][0] = cubeBack[1][2];
			cubeUp[2][0] = cubeBack[0][2];
			/////////////////////////////
			cubeBack[2][2] = cubeDown[2][2];
			cubeBack[1][2] = cubeDown[1][2];
			cubeBack[0][2] = cubeDown[0][2];
			/////////////////////////////
			cubeDown[0][2] = cubeFront[2][0];
			cubeDown[1][2] = cubeFront[1][0];
			cubeDown[2][2] = cubeFront[0][0];
			/////////////////////////////
			cubeFront[0][0] = tmp[0];
			cubeFront[1][0] = tmp[1];
			cubeFront[2][0] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeLeft[0][0];
			cubeLeft[0][0] = cubeLeft[2][0];
			cubeLeft[2][0] = cubeLeft[2][2];
			cubeLeft[2][2] = cubeLeft[0][2];
			cubeLeft[0][2] = tmp[0];
			tmp[1] = cubeLeft[0][1];
			cubeLeft[0][1] = cubeLeft[1][0];
			cubeLeft[1][0] = cubeLeft[2][1];
			cubeLeft[2][1] = cubeLeft[1][2];
			cubeLeft[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeUp[0][0] = cubeFront[0][0];
			cubeUp[1][0] = cubeFront[1][0];
			cubeUp[2][0] = cubeFront[2][0];
			/////////////////////////////
			cubeFront[0][0] = cubeDown[2][2];
			cubeFront[1][0] = cubeDown[1][2];
			cubeFront[2][0] = cubeDown[0][2];
			/////////////////////////////
			cubeDown[0][2] = cubeBack[0][2];
			cubeDown[1][2] = cubeBack[1][2];
			cubeDown[2][2] = cubeBack[2][2];
			/////////////////////////////
			cubeBack[0][2] = tmp[2];
			cubeBack[1][2] = tmp[1];
			cubeBack[2][2] = tmp[0];
			/////////////////////////////
			tmp[0] = cubeLeft[0][0];
			cubeLeft[0][0] = cubeLeft[0][2];
			cubeLeft[0][2] = cubeLeft[2][2];
			cubeLeft[2][2] = cubeLeft[2][0];
			cubeLeft[2][0] = tmp[0];
			tmp[1] = cubeLeft[0][1];
			cubeLeft[0][1] = cubeLeft[1][2];
			cubeLeft[1][2] = cubeLeft[2][1];
			cubeLeft[2][1] = cubeLeft[1][0];
			cubeLeft[1][0] = tmp[1];
		}
	}
	private static void rotateRight(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeUp[0][2];
		tmp[1] = cubeUp[1][2];
		tmp[2] = cubeUp[2][2];
		if(d == 1)//시계방향
		{
			cubeUp[0][2] = cubeFront[0][2];
			cubeUp[1][2] = cubeFront[1][2];
			cubeUp[2][2] = cubeFront[2][2];
			/////////////////////////////
			cubeFront[0][2] = cubeDown[2][0];
			cubeFront[1][2] = cubeDown[1][0];
			cubeFront[2][2] = cubeDown[0][0];
			/////////////////////////////
			cubeDown[0][0] = cubeBack[0][0];
			cubeDown[1][0] = cubeBack[1][0];
			cubeDown[2][0] = cubeBack[2][0];
			/////////////////////////////
			cubeBack[0][0] = tmp[2];
			cubeBack[1][0] = tmp[1];
			cubeBack[2][0] = tmp[0];
			/////////////////////////////
			tmp[0] = cubeRight[0][0];
			cubeRight[0][0] = cubeRight[2][0];
			cubeRight[2][0] = cubeRight[2][2];
			cubeRight[2][2] = cubeRight[0][2];
			cubeRight[0][2] = tmp[0];
			tmp[1] = cubeRight[0][1];
			cubeRight[0][1] = cubeRight[1][0];
			cubeRight[1][0] = cubeRight[2][1];
			cubeRight[2][1] = cubeRight[1][2];
			cubeRight[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeUp[0][2] = cubeBack[2][0];
			cubeUp[1][2] = cubeBack[1][0];
			cubeUp[2][2] = cubeBack[0][0];
			/////////////////////////////
			cubeBack[0][0] = cubeDown[0][0];
			cubeBack[1][0] = cubeDown[1][0];
			cubeBack[2][0] = cubeDown[2][0];
			/////////////////////////////
			cubeDown[0][0] = cubeFront[2][2];
			cubeDown[1][0] = cubeFront[1][2];
			cubeDown[2][0] = cubeFront[0][2];
			/////////////////////////////
			cubeFront[0][2] = tmp[0];
			cubeFront[1][2] = tmp[1];
			cubeFront[2][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeRight[0][0];
			cubeRight[0][0] = cubeRight[0][2];
			cubeRight[0][2] = cubeRight[2][2];
			cubeRight[2][2] = cubeRight[2][0];
			cubeRight[2][0] = tmp[0];
			tmp[1] = cubeRight[0][1];
			cubeRight[0][1] = cubeRight[1][2];
			cubeRight[1][2] = cubeRight[2][1];
			cubeRight[2][1] = cubeRight[1][0];
			cubeRight[1][0] = tmp[1];
		}
	}
	private static void rotateBack(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeRight[0][2];
		tmp[1] = cubeRight[1][2];
		tmp[2] = cubeRight[2][2];
		if(d == 1)//시계방향
		{
			cubeRight[0][2] = cubeDown[0][0];
			cubeRight[1][2] = cubeDown[0][1];
			cubeRight[2][2] = cubeDown[0][2];
			/////////////////////////////
			cubeDown[0][0] = cubeLeft[2][0];
			cubeDown[0][1] = cubeLeft[1][0];
			cubeDown[0][2] = cubeLeft[0][0];
			/////////////////////////////
			cubeLeft[0][0] = cubeUp[0][2];
			cubeLeft[1][0] = cubeUp[0][1];
			cubeLeft[2][0] = cubeUp[0][0];
			/////////////////////////////
			cubeUp[0][0] = tmp[0];
			cubeUp[0][1] = tmp[1];
			cubeUp[0][2] = tmp[2];
			/////////////////////////////	
			tmp[0] = cubeBack[0][0];
			cubeBack[0][0] = cubeBack[2][0];
			cubeBack[2][0] = cubeBack[2][2];
			cubeBack[2][2] = cubeBack[0][2];
			cubeBack[0][2] = tmp[0];
			tmp[1] = cubeBack[0][1];
			cubeBack[0][1] = cubeBack[1][0];
			cubeBack[1][0] = cubeBack[2][1];
			cubeBack[2][1] = cubeBack[1][2];
			cubeBack[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeRight[0][2] = cubeUp[0][0];
			cubeRight[1][2] = cubeUp[0][1];
			cubeRight[2][2] = cubeUp[0][2];
			/////////////////////////////
			cubeUp[0][0] = cubeLeft[2][0];
			cubeUp[0][1] = cubeLeft[1][0];
			cubeUp[0][2] = cubeLeft[0][0];
			/////////////////////////////
			cubeLeft[0][0] = cubeDown[0][2];
			cubeLeft[1][0] = cubeDown[0][1];
			cubeLeft[2][0] = cubeDown[0][0];
			/////////////////////////////
			cubeDown[0][0] = tmp[0];
			cubeDown[0][1] = tmp[1];
			cubeDown[0][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeBack[0][0];
			cubeBack[0][0] = cubeBack[0][2];
			cubeBack[0][2] = cubeBack[2][2];
			cubeBack[2][2] = cubeBack[2][0];
			cubeBack[2][0] = tmp[0];
			tmp[1] = cubeBack[0][1];
			cubeBack[0][1] = cubeBack[1][2];
			cubeBack[1][2] = cubeBack[2][1];
			cubeBack[2][1] = cubeBack[1][0];
			cubeBack[1][0] = tmp[1];
		}
	}
	private static void rotateFront(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeLeft[0][2];
		tmp[1] = cubeLeft[1][2];
		tmp[2] = cubeLeft[2][2];
		if(d == 1)//시계방향
		{
			cubeLeft[0][2] = cubeDown[2][2];
			cubeLeft[1][2] = cubeDown[2][1];
			cubeLeft[2][2] = cubeDown[2][0];
			/////////////////////////////
			cubeDown[2][0] = cubeRight[0][0];
			cubeDown[2][1] = cubeRight[1][0];
			cubeDown[2][2] = cubeRight[2][0];
			/////////////////////////////
			cubeRight[0][0] = cubeUp[2][0];
			cubeRight[1][0] = cubeUp[2][1];
			cubeRight[2][0] = cubeUp[2][2];
			/////////////////////////////
			cubeUp[2][2] = tmp[0];
			cubeUp[2][1] = tmp[1];
			cubeUp[2][0] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeFront[0][0];
			cubeFront[0][0] = cubeFront[2][0];
			cubeFront[2][0] = cubeFront[2][2];
			cubeFront[2][2] = cubeFront[0][2];
			cubeFront[0][2] = tmp[0];
			tmp[1] = cubeFront[0][1];
			cubeFront[0][1] = cubeFront[1][0];
			cubeFront[1][0] = cubeFront[2][1];
			cubeFront[2][1] = cubeFront[1][2];
			cubeFront[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeLeft[0][2] = cubeUp[2][2];
			cubeLeft[1][2] = cubeUp[2][1];
			cubeLeft[2][2] = cubeUp[2][0];
			/////////////////////////////
			cubeUp[2][0] = cubeRight[0][0];
			cubeUp[2][1] = cubeRight[1][0];
			cubeUp[2][2] = cubeRight[2][0];
			/////////////////////////////
			cubeRight[0][0] = cubeDown[2][0];
			cubeRight[1][0] = cubeDown[2][1];
			cubeRight[2][0] = cubeDown[2][2];
			/////////////////////////////
			cubeDown[2][0] = tmp[2];
			cubeDown[2][1] = tmp[1];
			cubeDown[2][2] = tmp[0];
			/////////////////////////////
			tmp[0] = cubeFront[0][0];
			cubeFront[0][0] = cubeFront[0][2];
			cubeFront[0][2] = cubeFront[2][2];
			cubeFront[2][2] = cubeFront[2][0];
			cubeFront[2][0] = tmp[0];
			tmp[1] = cubeFront[0][1];
			cubeFront[0][1] = cubeFront[1][2];
			cubeFront[1][2] = cubeFront[2][1];
			cubeFront[2][1] = cubeFront[1][0];
			cubeFront[1][0] = tmp[1];
		}
	}
	private static void rotateDown(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeLeft[2][0];
		tmp[1] = cubeLeft[2][1];
		tmp[2] = cubeLeft[2][2];
		if(d == 1)//시계방향
		{
			cubeLeft[2][0] = cubeBack[2][0];
			cubeLeft[2][1] = cubeBack[2][1];
			cubeLeft[2][2] = cubeBack[2][2];
			/////////////////////////////
			cubeBack[2][0] = cubeRight[2][0];
			cubeBack[2][1] = cubeRight[2][1];
			cubeBack[2][2] = cubeRight[2][2];
			/////////////////////////////
			cubeRight[2][0] = cubeFront[2][0];
			cubeRight[2][1] = cubeFront[2][1];
			cubeRight[2][2] = cubeFront[2][2];
			/////////////////////////////
			cubeFront[2][0] = tmp[0];
			cubeFront[2][1] = tmp[1];
			cubeFront[2][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeDown[0][0];
			cubeDown[0][0] = cubeDown[2][0];
			cubeDown[2][0] = cubeDown[2][2];
			cubeDown[2][2] = cubeDown[0][2];
			cubeDown[0][2] = tmp[0];
			tmp[1] = cubeDown[0][1];
			cubeDown[0][1] = cubeDown[1][0];
			cubeDown[1][0] = cubeDown[2][1];
			cubeDown[2][1] = cubeDown[1][2];
			cubeDown[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeLeft[2][0] = cubeFront[2][0];
			cubeLeft[2][1] = cubeFront[2][1];
			cubeLeft[2][2] = cubeFront[2][2];
			/////////////////////////////
			cubeFront[2][0] = cubeRight[2][0];
			cubeFront[2][1] = cubeRight[2][1];
			cubeFront[2][2] = cubeRight[2][2];
			/////////////////////////////
			cubeRight[2][0] = cubeBack[2][0];
			cubeRight[2][1] = cubeBack[2][1];
			cubeRight[2][2] = cubeBack[2][2];
			/////////////////////////////
			cubeBack[2][0] = tmp[0];
			cubeBack[2][1] = tmp[1];
			cubeBack[2][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeDown[0][0];
			cubeDown[0][0] = cubeDown[0][2];
			cubeDown[0][2] = cubeDown[2][2];
			cubeDown[2][2] = cubeDown[2][0];
			cubeDown[2][0] = tmp[0];
			tmp[1] = cubeDown[0][1];
			cubeDown[0][1] = cubeDown[1][2];
			cubeDown[1][2] = cubeDown[2][1];
			cubeDown[2][1] = cubeDown[1][0];
			cubeDown[1][0] = tmp[1];
		}
	}
	private static void rotateUp(int d) {
		char[] tmp = new char[3];
		tmp[0] = cubeLeft[0][0];
		tmp[1] = cubeLeft[0][1];
		tmp[2] = cubeLeft[0][2];
		if(d == 1)//시계방향
		{
			cubeLeft[0][0] = cubeFront[0][0];
			cubeLeft[0][1] = cubeFront[0][1];
			cubeLeft[0][2] = cubeFront[0][2];
			/////////////////////////////
			cubeFront[0][0] = cubeRight[0][0];
			cubeFront[0][1] = cubeRight[0][1];
			cubeFront[0][2] = cubeRight[0][2];
			/////////////////////////////
			cubeRight[0][0] = cubeBack[0][0];
			cubeRight[0][1] = cubeBack[0][1];
			cubeRight[0][2] = cubeBack[0][2];
			/////////////////////////////
			cubeBack[0][0] = tmp[0];
			cubeBack[0][1] = tmp[1];
			cubeBack[0][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeUp[0][0];
			cubeUp[0][0] = cubeUp[2][0];
			cubeUp[2][0] = cubeUp[2][2];
			cubeUp[2][2] = cubeUp[0][2];
			cubeUp[0][2] = tmp[0];
			tmp[1] = cubeUp[0][1];
			cubeUp[0][1] = cubeUp[1][0];
			cubeUp[1][0] = cubeUp[2][1];
			cubeUp[2][1] = cubeUp[1][2];
			cubeUp[1][2] = tmp[1];
		}
		else//반시계방향
		{
			cubeLeft[0][0] = cubeBack[0][0];
			cubeLeft[0][1] = cubeBack[0][1];
			cubeLeft[0][2] = cubeBack[0][2];
			/////////////////////////////
			cubeBack[0][0] = cubeRight[0][0];
			cubeBack[0][1] = cubeRight[0][1];
			cubeBack[0][2] = cubeRight[0][2];
			/////////////////////////////
			cubeRight[0][0] = cubeFront[0][0];
			cubeRight[0][1] = cubeFront[0][1];
			cubeRight[0][2] = cubeFront[0][2];
			/////////////////////////////
			cubeFront[0][0] = tmp[0];
			cubeFront[0][1] = tmp[1];
			cubeFront[0][2] = tmp[2];
			/////////////////////////////
			tmp[0] = cubeUp[0][0];
			cubeUp[0][0] = cubeUp[0][2];
			cubeUp[0][2] = cubeUp[2][2];
			cubeUp[2][2] = cubeUp[2][0];
			cubeUp[2][0] = tmp[0];
			tmp[1] = cubeUp[0][1];
			cubeUp[0][1] = cubeUp[1][2];
			cubeUp[1][2] = cubeUp[2][1];
			cubeUp[2][1] = cubeUp[1][0];
			cubeUp[1][0] = tmp[1];
		}
	}
}