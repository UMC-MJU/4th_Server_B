package 백준_4단계_;

import java.util.Scanner;

public class 백준_4단계_X보다작은수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		int array[] =new int [N] ;
		int i =0;
		
		
		for(i=0; i<N; i++) 
		{
			array[i] = sc.nextInt();
		}
		for(i=0; i<N; i++)
		{
			if(array[i] < X) 
				{
				System.out.print(array[i] + " ");
				}
		}
		sc.close();
	}

}
