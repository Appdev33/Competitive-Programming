package LongestCommonSubsequence;
//https://www.youtube.com/watch?v=RiNzHfoA2Lo
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		String str1 = "abcdefklo";
	
		int m = str1.length();
		char str2[] = new char[m];
		int index=0;
		for(int i=m-1;i>=0;i--)
			str2[index++]=str1.charAt(i);
		
		for(int i=0;i<m;i++)
			System.out.println(str2[i]);
		
		System.out.println(LPS(str1.toCharArray(),m,str2,m) );

	}

	private static int LPS(char[] M, int m, char[] N, int n) {
		// TODO Auto-generated method stub
		if(m==0 || n==0)
			return 0;
		if(M[m-1]==N[n-1]) 
			return 1+ LPS(M,m-1,N,n-1);
		else 
			return Math.max(LPS(M,m-1,N,n), LPS(M,m,N,n-1));
		}

}
