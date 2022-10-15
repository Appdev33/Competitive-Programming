package KnapSackDp;

import java.util.Arrays;

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class MinSubetSum {
	
	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = {1,6,5,23};
		int sum  = 0;
		for(int i: ar)
			sum+=i;
		
//		System.out.println(MinSubset(ar,ar.length,0,sum) );
		memo = new int[ar.length+1][sum+1];
		for(int i[]: memo)
			Arrays.fill(i, -1);
		
//		System.out.println(MinSubset(ar,ar.length,0,sum) );
		
		System.out.println(MinSubsetDp(ar,ar.length,0,sum) );
	}
	
	public static int MinSubset(int ar[],int n, int sumCalculated,int sumTotal) {
		if(n==0)  // reached and populated both subsets than
			return Math.abs(sumTotal-2*sumCalculated);
		
	
		return  Math.min(MinSubset(ar,n-1,sumCalculated+ar[n-1],sumTotal),
				MinSubset(ar,n-1,sumCalculated,sumTotal));
	}
	
	
//	public static int MinSubsetMemo(int ar[],int n, int sumCalculated,int sumTotal) {
//		if(n==0)
//			return Math.abs(sumTotal-2*sumCalculated);
//		
//		if(memo[n][sumTotal]!=-1)
//			return memo[n][sumTotal];
//		
//		return memo[n][sumTotal] = Math.min(MinSubsetMemo(ar,n-1,sumCalculated+ar[n-1],sumTotal),
//				MinSubsetMemo(ar,n-1,sumCalculated,sumTotal));
//	}
	
	
	public static int MinSubsetDp(int ar[],int n, int sumCalculated,int sumTotal) {
		
		boolean dp[][] = new boolean[n+1][sumTotal+1];
		for(int i=0; i<=sumTotal;i++) {
			dp[0][i]=false;
		}
		for(int i=0; i<=n;i++) {
			dp[i][0]=true;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sumTotal; j++) {
				if(ar[i-1]>j)
				 dp[i][j] = dp[i-1][j];
				else
				 dp[i][j] = dp[i-1][j] | dp[i-1][j-ar[i-1]];	
			}
		}
		
		int res= Integer.MAX_VALUE;
		
		for(int i=0; i<=sumTotal/2; i++) {
			if(dp[n][i]==true)
				res = Math.min(res,sumTotal-2*i );
		}
		
		// Reduced space
//		int len = sumTotal/2+1;
		boolean dp1[] = new boolean[sumTotal+1];
		
		
//		for (int i = 0; i <=sumTotal ; i++) 
//			 dp1[i]= false;
//		dp1[0]=true;
//		
//		
//		for(int i=0;i<n;i++) {
//			for(int j=sumTotal; j>0; j--) {
//				dp1[j] = dp1[j] | dp1[j-ar[i]];
//			}
//		}
//		
//		for (int i = 0; i <=sumTotal ; i++)
//			System.out.println(dp1[i]);
		
		return res;
	}
}
