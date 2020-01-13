package DynamicProgramming;

import java.util.*;

public class Candy 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		String g = sc.nextLine();
		String[] gstr = g.split("\\[|\\]|,");
		int i , sum = 0;
		List<Integer> A = new ArrayList<>();
		List<Integer> Candy = new ArrayList<>();
		for(i = 1 ; i < gstr.length ; i++)
		{
			A.add(Integer.valueOf(gstr[i]));
		}
		//每个孩子先分配一颗糖果
		for(i = 0 ; i < A.size() ; i++)
		{
			Candy.add(1);
		}
		//从前往后扫描，如满足相邻两个小孩后面的权重大于前面的权重的情况，后面的小孩在前面的小孩的糖果数的基础上加一个。  O(n)
		for(i = 0 ; i < A.size() ; i++)
		{
			if(i >= 1)
			{
				if(A.get(i) > A.get(i-1)) 
				{
					Candy.set(i, Candy.get(i-1)+1);
				}
			}
				
		} 
		//从后往前扫描，如满足相邻两个小孩前面的权重大于前面的权重的情况。  O(n)
		//这样两遍扫描下来就可以保证权重高的孩子比相邻权重低的孩子的糖果多。
		for(i = A.size() - 1 ; i >= 0  ; i--)
		{
			if(i <= A.size() - 2)
			{
				if(A.get(i) > A.get(i+1)) 
				{
					Candy.set(i, Candy.get(i+1)+1);
				}
			}
				
		}
		//求和  O(n)
		for(i = 0 ; i < A.size() ; i++)
		{
			System.out.println(Candy.get(i));
			sum += Candy.get(i);
		}
		System.out.println("Output:");
		System.out.println(sum);
		
	}
}
