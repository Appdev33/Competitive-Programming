package LongestCommonSubsequence;

public class PrintLCSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefklorstuvwxyz";
		String str2 = "abdfkloprstuvwyz";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(LCSubstringDp(str1.toCharArray(),m,str2.toCharArray(),n,str1) );
	}
	
	private static int LCSubstringDp(char[] M, int m, char[] N, int n,String str1) {
		int dp[][] = new int[m+1][n+1];
	
		int Endindex=0;
		int maxLen=0;
		 for (int i = 0; i <= m; i++) {
		        for (int j = 0; j <= n; j++) {
		            if (i == 0 || j == 0)
		                dp[i][j] = 0;
		 
		            else if (M[i - 1] == N[j - 1]) {
		                dp[i][j] = dp[i - 1][j - 1] + 1;
		                if (maxLen < dp[i][j]) {
		                    maxLen = dp[i][j];
		                    Endindex=i;
		                }
		            }
		            else
		                dp[i][j] = 0;
		        }
		    }
		    
			System.out.println(str1.substring(Endindex-maxLen,Endindex) );

		
		return maxLen;
	}

}
