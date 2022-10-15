package LongestCommonSubsequence;

import java.util.Arrays;

public class MinInsertionMakePalindrome {

	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aebcbda";
		int m = str1.length();
		char str2[] = new char[m];
		int index=0;
		for(int i=m-1;i>=0;i--)
			str2[index++]=str1.charAt(i);

		memo = new int[m+1][m+1];
		for(int a[]: memo)
			Arrays.fill(a,-1);
		
		System.out.println(m-LCS(str1.toCharArray(),m,str2,m) );
	}

	private static int LCS(char[] M, int m, char[] N, int n) {
		// TODO Auto-generated method stub
		if(m==0 || n==0)
			return 0;
		
		if(M[m-1]==N[n-1])
			return 1+LCS(M,m-1,N,n-1);
		else
			return Math.max(LCS(M,m,N,n-1),LCS(M,m-1,N,n));
	}
}
