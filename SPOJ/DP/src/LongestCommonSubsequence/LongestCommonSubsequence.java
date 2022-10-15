package LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {

	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "abcdefklo";
		String str2 = "abdefklo";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(LCS(str1.toCharArray(),m,str2.toCharArray(),n) );
		memo = new int[n+1][m+1];
		
		for(int ar[] : memo)
			Arrays.fill(ar,-1);
		
		System.out.println(LCSMemo(str1.toCharArray(),m,str2.toCharArray(),n) );
		System.out.println(LCSDp(str1.toCharArray(),m,str2.toCharArray(),n) );		
	}

	private static int LCSMemo(char[] M, int m, char[] N, int n) {
		if(m==0 || n==0)
			return 0;
		
		if(memo[m-1][n-1]!=-1)
			return memo[m-1][n-1];
		
		if(M[m-1]==N[n-1])
			return memo[m-1][n-1] = 1+LCS(M,m-1,N,n-1);
		else
			return memo[m-1][n-1] = Math.max(LCS(M,m,N,n-1),LCS(M,m-1,N,n));
		
	}
	
	private static int LCS(char[] M, int m, char[] N, int n) {
		if(m==0 || n==0)
			return 0;
		
		if(M[m-1]==N[n-1])
			return 1+LCS(M,m-1,N,n-1);
		else
			return Math.max(LCS(M,m,N,n-1),LCS(M,m-1,N,n));
		
	}
	
	
	private static int LCSDp(char[] M, int m, char[] N, int n) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(M[m-1]==N[n-1])
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		
		
		return dp[m][n];
	}
}
