import java.util.Arrays;

public class GeneralKnapSack {

	static int memo[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int profit[] = { 60, 100, 120 };
 		int wt[] = { 10, 20, 30 };
 		int capacity= 50;
 		int n = wt.length;
 		memo = new int[n+1][capacity+1];
 		for(int ar[]: memo)
 			Arrays.fill(ar, -1);
 		
 		System.out.println( KnapSack01TopDown(wt,profit,capacity) ); 
// 		System.out.println(KnapSack01(wt,profit,capacity,wt.length-1,0) );
	}
	
	public static int KnapSack01(int wt[],int value[],int capacity,int n,int profit) {
		
		if(n==0 || capacity==0)
			return 0;
		
//		if(memo[n][capacity]!=-1)      For Memoisation Bottom Up
//			return memo[n][capacity];
		
		if(wt[n]>capacity) {
			return KnapSack01(wt,value,capacity,n-1,profit);
		}else {
			
			int choose = KnapSack01(wt,value,capacity,n-1,profit);
			int notChoose =	KnapSack01(wt,value,capacity,n-1,profit);	
			
			return memo[n][capacity]=value[n]+Math.max(choose, notChoose);
		}
	}
	
	public static int KnapSack01TopDown(int wt[],int value[],int cap) {
		int W = wt.length;
		int dp[][] = new int[cap+1][W+1];
		
		for(int n=0; n<=W; n++) {
			for(int weight=0; weight<=cap; weight++) {
				if(n==0 || weight ==0)
					dp[weight][n]=0;
				else if(wt[n-1]<=weight){
					dp[weight][n]=  Math.max(dp[weight][n-1],value[n-1] + dp[weight-wt[n-1]][n-1] );
				}
				else {
					dp[weight][n]=dp[weight][n-1];
				}
			}
		}
		
		return dp[cap][W];
		
	}
}
