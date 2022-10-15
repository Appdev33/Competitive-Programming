package LongestCommonSubsequence;

import java.util.Arrays;

public class ConvertAtoB {

	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
		String str2 = "abdfklo";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(m+n-2*ConvertAToB(str1.toCharArray(),m,str2.toCharArray(),n) );
		
		memo = new int[m+1][n+1];
		for(int a[]: memo)
			Arrays.fill(a,-1);
		
		System.out.println(ConvertAToBMemo(str1.toCharArray(),m,str2.toCharArray(),n) );
		System.out.println(ConvertAToBDP(str1.toCharArray(),m,str2.toCharArray(),n) );
	}

	private static int ConvertAToB(char[] M, int m, char[] N, int n) {

		if(m==0 || n==0 )
			return 0;
		
		if(M[m-1]==N[n-1])
			return 1+ConvertAToB(M,m-1,N,n-1);
		else
			return Math.max(ConvertAToB(M,m-1,N,n), ConvertAToB(M,m,N,n-1));
	}
	
	private static int ConvertAToBMemo(char[] M, int m, char[] N, int n) {

		if(m==0 || n==0 )
			return 0;
		
		if(memo[m][n]!=-1)
			return memo[m][n];
		
		
		if(M[m-1]==N[n-1])
			return memo[m][n] = 1+ConvertAToB(M,m-1,N,n-1);
		else
			return memo[m][n] = Math.max(ConvertAToB(M,m-1,N,n), ConvertAToB(M,m,N,n-1));
	}
	
	
	private static int ConvertAToBDP(char[] M, int m, char[] N, int n) {

		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(M[i-1]==N[j-1])
					dp[i][j]= 1+(dp[i-1][j-1]);
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		
		return dp[m][n];
	}

}
