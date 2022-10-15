package LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubstring {

	static int memo[][];
	public static void main(String[] args) {
		
		String str1 = "abcdefklorstuvw";
		String str2 = "abdfkloprstuvw";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(LCSubstring(str1.toCharArray(),m,str2.toCharArray(),n,0) );
		
		memo = new int[n+1][m+1];
		
		for(int ar[] : memo)
			Arrays.fill(ar,0);
		
		System.out.println(LCSubstringMemo(str1.toCharArray(),m-1,str2.toCharArray(),n-1,0) );
		
//		for(int i=0; i<=m; i++) {
//			for(int j=0; j<=n; j++) {
//				System.out.print(memo[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(LCSubstringDp(str1.toCharArray(),m,str2.toCharArray(),n) );
	
	}

	private static int LCSubstring(char[] M, int m, char[] N, int n,int res) {
		if(m==0 || n==0)
			return res;
		
		if(M[m-1]==N[n-1])
			return LCSubstring(M,m-1,N,n-1,res+1);
		
		return Math.max(res, Math.max(LCSubstring(M,m,N,n-1,0),LCSubstring(M,m-1,N,n,0) ));
	}
	
//	static int ans=0;
	private static int LCSubstringMemo(char[] M, int m, char[] N, int n,int res)   
	{                        
		if(m==0 || n==0)
			return res;
		
		  if(memo[m][n] != 0) 
		  return memo[m][n];
		
		if(M[m]==N[n])
			return memo[m][n]=LCSubstringMemo(M,m-1,N,n-1,res+1);
		
		return memo[m][n] = Math.max(res, Math.max(LCSubstringMemo(M,m,N,n-1,0),LCSubstringMemo(M,m-1,N,n,0) ));
	}
	
	
	private static int LCSubstringDp(char[] M, int m, char[] N, int n) {
		int dp[][] = new int[m+1][n+1];
		int lenMax = 0 ;
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
//				if(i==0 || j==0)
//					dp[i][j]=0;
				if(M[i-1]==N[j-1]) {
					dp[i][j] = 1+dp[i-1][j-1];
					lenMax = Integer.max(lenMax,
                            dp[i][j]);
				}
				else
					dp[i][j] = 0;
			}
		}
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
		
		return lenMax;
	}
}
