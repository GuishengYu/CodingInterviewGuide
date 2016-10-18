package chapter4;

import java.util.Scanner;

public class Fibonacci {
	//method1，O(2^N)
	public int f1(int n){
		if(n == 0){
			return 0;
		}
		if((n == 1)||(n == 2)){
			return 1;
		}
		return f1(n-1)+f1(n-2);
	}
	//method2，O(N)
	public int f2(int n){
		if(n==0){
			return 0;
		}
		if((n==1)||(n==2)){
			return 1;
		}
		int res = 1;
		int tmp;
		int pre = 1;
		for(int i = 3;i <= n;i++){
			tmp = res;
			res = res + pre;
			pre = res;
		}
		return res;
	}
	
	//method3，O（log N）
	public int[][] matrixPower(int[][] m, int p){
		int[][] res = new int[m.length][m[0].length];
		for(int i = 0; i < m.length; i++)
			res[i][i] = 1;
		int[][] tmp = m;
		for(; p != 0;p >>=1){
			if((p&1) != 0)
				res = muliMatrix(res,tmp);
			tmp = muliMatrix(tmp,tmp);
		}
		return res;
	}
	public int[][] muliMatrix(int[][] m1, int[][] m2){
		int[][] tmp = new int[m1.length][m2[0].length]; 
		for(int i = 0; i < m1.length; i++){
			for(int j = 0; j < m2[0].length; j++){
				for(int k = 0; k < m2.length; k++)
					tmp[i][j] += m1[i][k] + m2[k][j];
			}	
		}
		return tmp;
	}
	public static void main(String [] args){	
		Fibonacci fc = new Fibonacci();
		while(true){
			System.out.println("请输入第几项斐波拉契数：");
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			if(n < 0)
				break;
			System.out.println(fc.f1(n));
			in.close();
		}
		
		
	}
}
