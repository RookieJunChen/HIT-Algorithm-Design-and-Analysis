package DynamicProgramming;

import java.util.Scanner;

public class edit {
public static void main(String[] args) {
	int i , j;
	Scanner sc = new Scanner(System.in);
	System.out.println("Input:");
	String A = sc.next();
	String B = sc.next();
	int[][] edit = new int[A.length()+1][B.length()+1];
	for(j = 0 ; j <= B.length() ; j++)
	{
		edit[0][j] = j;
	}
	for(i = 1; i <= A.length() ; i++)
	{
		edit[i][0] = i;
	}
	for( i = 0; i < A.length() ; i++)
	{
		int m = i + 1;
		for( j = 0; j < B.length(); j++)
		{
			
			int n = j + 1;
			if(A.charAt(i) == B.charAt(j))
			{
				edit[m][n] = edit[m-1][n-1];
			}
			else
			{
				edit[m][n] = edit[m-1][n-1] + 1;
				if((edit[m][n-1]+1) < edit[m][n])
				{
					edit[m][n] = edit[m][n-1] + 1;
				}
				if((edit[m-1][n]+1) < edit[m][n])
				{
					edit[m][n] = edit[m-1][n] + 1;
				}
			}
		}
	}
	System.out.println("Output:");
	System.out.println(edit[A.length()][B.length()]);
}
}
