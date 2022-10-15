package LongestCommonSubsequence;

public class PrintShortestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
//		String str2 = "abdfklo";
		String str2 = "";
//		String str1 = "abc";
//		String str2 = "abdef";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(m+n-PSCS(str1.toCharArray(),m,str2.toCharArray(),n) );

	}

	private static int PSCS(char[] M, int m, char[] N, int n) {
		// TODO Auto-generated method stub
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n;j++) {
				if(i==0||j==0)
					dp[i][j]=0;
				else if(M[i-1]==N[j-1]){
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		int i=m;
		int j=n;
		StringBuilder sbr = new StringBuilder();
		while(i>0 && j>0) {
			if(M[i-1]==N[j-1]) {
				sbr.append(M[i-1]);
				i--;j--;
			}else {
				//remove 2 to make print LCS
				// just before moving in direction add from which moving up 
				//don't add anython in block to make LCS
				//take care of append before i-- || j--
				if(dp[i-1][j]>dp[i][j-1] ) {
					sbr.append(M[i-1]);
					i--;
				}else {
					sbr.append(N[j-1]);
					j--;
				}
			}
		}
		// for SCS "ab" && ""  ab is answer not same in case of LCS hence while loop
		while(i>0) {
			sbr.append(M[i-1]);
			i--;
		}
		
		while(j>0) {
			sbr.append(N[j-1]);
			j--;
		}
			
		
		
		
		System.out.println(sbr.reverse().toString());
		return 0;
	}

}
