package LongestCommonSubsequence;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
		String str2 = "abdfklo";
		
		int m = str1.length();
		int n = str2.length();
		
		System.out.println(m+n - SCS(str1.toCharArray(),m,str2.toCharArray(),n) );
		//m-SCS+n-SCS+SCS
	}

	private static int SCS(char[] M, int m, char[] N , int n) {
		if(m==0 || n==0)
			return 0;
		
		if(M[m-1] == N[n-1])
			return 1+SCS(M,m-1,N,n-1);
		else
			return Math.max(SCS(M,m-1,N,n),SCS(M,m,N,n-1));
		
//		return 0;
	}

}
