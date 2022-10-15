package KnapSackDp;
import java.util.Arrays;

public class GeneralKnapSack {

	static int memo[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int profit[] = { 1, 6, 10, 16 };
 		int wt[] = { 1, 2, 3, 5 };
 		int capacity= 6;
 		int n = wt.length;
 		memo = new int[n+1][capacity+1];
 		for(int ar[]: memo)
 			Arrays.fill(ar, -1);
 		
 		System.out.println( KnapSack01(wt,profit,capacity,wt.length-1,0) ); 
		
 		for(int i=0; i<=n;i++) {
			for(int j=0;j<=capacity;j++) {
				System.out.print(memo[i][j]+"   ");
			}
			System.out.println();
		}
 		
 		System.out.println(KnapSack01TopDown(wt,profit,capacity) );
	}
	
	public static int KnapSack01(int wt[],int value[],int capacity,int n,int profit) {
		
		if(n==0 || capacity==0)
			return 0;
		
		if(memo[n][capacity]!=-1)      //For Memoisation Bottom Up
			return memo[n][capacity];
		
		if(wt[n]>capacity) {
			return KnapSack01(wt,value,capacity,n-1,profit);
		}else {
			//value[n-1] this was an important line
			int choose = value[n-1]+KnapSack01(wt,value,capacity,n-1,profit);
			int notChoose =	KnapSack01(wt,value,capacity,n-1,profit);	
			
			return memo[n][capacity]=Math.max(choose, notChoose);
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
		
		System.out.println("*****************************************");
		
 		for(int i=0; i<=cap;i++) {
			for(int j=0;j<=W;j++) {
				System.out.print(dp[i][j]+"   ");
			}
			System.out.println();
		}
		
		
		return dp[cap][W];
		
	}
}
