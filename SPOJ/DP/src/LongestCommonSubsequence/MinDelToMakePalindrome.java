package LongestCommonSubsequence;

public class MinDelToMakePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
		
		int m = str1.length();
		char str2[] = new char[m];
		int index=0;
		for(int i=m-1;i>=0;i--)
			str2[index++]=str1.charAt(i);
		
//		for(int i=0;i<m;i++)
//			System.out.println(str2[i]);
		
		System.out.println(m-LPS(str1.toCharArray(),m,str2,m) );	
	}

	private static int LPS(char[] M, int m, char[] N, int n) {
		// TODO Auto-generated method stub
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					dp[i][j]=0;
				else if(M[i-1]==N[j-1])
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		return dp[m][n];
	}

}
