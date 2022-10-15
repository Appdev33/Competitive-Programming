package LongestCommonSubsequence;

public class PrintLCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
		String str2 = "abdefklo";
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(LCSDp(str1.toCharArray(),m,str2.toCharArray(),n) );
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
		
		int i= m; 
		int j=n;
		
		StringBuilder sbr = new StringBuilder();
		while(i>0 || j>0) {
			if(M[i-1]==N[j-1]) {
				sbr.append(M[i-1]);
				i--;
				j--;
			}else{
				if(dp[i-1][j]>dp[i][j-1])
					i=i-1;
				else
					j=j-1;
			}
		}
		
		System.out.println(sbr.reverse().toString());
		
		return dp[m][n];
	}
}
