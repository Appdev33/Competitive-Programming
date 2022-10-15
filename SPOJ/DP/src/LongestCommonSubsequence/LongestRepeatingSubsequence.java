package LongestCommonSubsequence;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aabebecdd";
		String str2 = "aabebecdd";
		int m = str1.length();
		int n = str2.length();
		int res =0;

		res = Math.max(res,LCS(str1.toCharArray(),m,str2.toCharArray(),n));
		System.out.println(res);
	}

	private static int LCS(char[] M, int m, char[] N, int n) {
		if(m==0 || n==0)
			return 0;
		
		if(M[m-1]==N[n-1] && m!= n )
			return 1+LCS(M,m-1,N,n-1);
		else
			return Math.max(LCS(M,m,N,n-1),LCS(M,m-1,N,n));
	}
}
