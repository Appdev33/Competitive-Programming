package UnboundedKnapsack;

import java.util.Arrays;

public class CoinChange {

	static int memo[][];
	public static void main(String[] args) {
		
		int coins[] = {1,2,3};
		int target =5;
		System.out.println(CoinChange(coins,target,coins.length));
		memo = new int[coins.length+1][target+1];
		
		for(int ar[]:memo) {
			Arrays.fill(ar,-1);
		}
		
		System.out.println(CoinChangeMemo(coins,target,coins.length));
		System.out.println(CoinChangeDp(coins,target,coins.length));
	}
	
	private static int CoinChangeDp(int[] coins, int target, int n) {
		int dp[][] = new int[n+1][target+1];
		
		for(int i=0; i<=target; i++) {
			dp[0][i]=0;
		}
		for(int i=0; i<=n; i++) {
			dp[i][0]=1;
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(coins[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]= dp[i-1][j] + dp[i][j-coins[i-1]];
			}
		}
		
		
		return dp[n][target];
	}

	public static int CoinChange(int[] coins, int target, int n) {
		if(target==0)
			return 1;
		if(n<=0 || target<0)
			return 0;
		
		if(coins[n-1]>target) {
			return CoinChange(coins,target,n-1);
		}else {
			return CoinChange(coins,target,n-1) + CoinChange(coins,target-coins[n-1],n);
		}
	}
	
	public static int CoinChangeMemo(int[] coins, int target, int n) {
		
		if(target==0)
			return 1;
		if(n<=0 || target<0)
			return 0;
		
		if(memo[n][target]!=-1)
			return memo[n][target];
		
		if(coins[n-1]>target) {
			return memo[n][target]=CoinChange(coins,target,n-1);
		}else {
			return memo[n][target] =CoinChange(coins,target,n-1) + CoinChange(coins,target-coins[n-1],n);
		}
	}
}
