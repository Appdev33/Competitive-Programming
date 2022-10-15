package UnboundedKnapsack;

import java.util.Arrays;

public class MinCoinChangeCount {
	
	static int memo[][];
	public static void main(String[] args) {
		int coins[] =  {1,2,3,5,6,7,8};
		int target = 81;		
		System.out.println(MinCoinChangeCount(coins,target,coins.length));
		memo = new int[coins.length+1][target+1];
		for(int i[]: memo)
			Arrays.fill(i,Integer.MAX_VALUE-1);
		
		System.out.println(MinCoinChangeCountMemo(coins,target,coins.length));
		System.out.println(MinCoinChangeCountDP(coins,target,coins.length));
	}

	private static int MinCoinChangeCount(int[] coins, int target, int n) {
		
		if(target==0)
			return 0;
		
		if(n<=0 || target<0)
			return Integer.MAX_VALUE-1;
		
		if(coins[n-1]>target)
			return MinCoinChangeCount(coins,target,n-1);
		
		int notTake =  MinCoinChangeCount(coins,target,n-1);
		int take = 1+MinCoinChangeCount(coins,target-coins[n-1],n);
		
		return Math.min(take,notTake);
	}
	
	private static int MinCoinChangeCountMemo(int[] coins, int target, int n) {
			
			if(target==0)
				return 0;
			
			if(n<=0 || target<0)
				return Integer.MAX_VALUE-1;
			
			if(memo[n][target]!=Integer.MAX_VALUE-1)
				return memo[n][target];
			
			if(coins[n-1]>target)
				return memo[n][target]=MinCoinChangeCount(coins,target,n-1);
			
			int notTake =  MinCoinChangeCount(coins,target,n-1);
			int take = 1+MinCoinChangeCount(coins,target-coins[n-1],n);
			
			return memo[n][target] = Math.min(take,notTake);
	}
	
	
	private static int MinCoinChangeCountDP(int[] coins, int amount, int n) {
		
		int[][] dp = new int[n + 1][amount + 1];
        for(int j = 1; j < amount + 1; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(j >= coins[i - 1]){
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int result = dp[n][amount];
        	if(result == Integer.MAX_VALUE - 1) 
        		return -1;
        	else 
        		return result;
		
	}
}
