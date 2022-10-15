package LongestCommonSubsequence;

public class SequencePatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abed";
		String str2 = "aabebecdd";
		int m = str1.length();
		int n = str2.length();
		
		int length = SPM(str1.toCharArray(),m,str2.toCharArray(),n,str1) ;
		System.out.println(length==m);
	}
	
	
	private static int SPM(char[] M, int m, char[] N, int n,String str1) {
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0||j==0)
					dp[i][j]=0;
				else if(M[i-1]==N[j-1])
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		return dp[m][n];
	}

}
