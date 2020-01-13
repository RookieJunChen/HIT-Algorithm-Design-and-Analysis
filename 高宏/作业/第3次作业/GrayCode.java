package DynamicProgramming;

import java.lang.Math;
import java.util.Scanner;


public class GrayCode {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int i;
		System.out.println("Input:");
		int n = sc.nextInt();
		int[] a = divide(n);
		System.out.println("Output:");
		System.out.print("[ ");
		for(i = 0; i < a.length ; i++)
		{
			System.out.print(" " + a[i] + " ");
		}
		System.out.print(" ]");
	}
	
	
	public static int[] divide(int n)
	{
		int i , j;
		if(n == 1)
		{
			return new int[] {0,1};
		}
		else
		{
			int[] temp = divide(n-1);
			int[] ret = new int[temp.length * 2];
			for(i = 0 ; i < temp.length ; i++)
			{
				ret[i] = temp[i];
			}
			for(i = temp.length , j = temp.length - 1 ; i < ret.length && j >= 0 ; i++ , j--)
			{
				ret[i] = temp[j] + (int)Math.pow(2, n-1);
			}
			return ret;
		}
	}
}
