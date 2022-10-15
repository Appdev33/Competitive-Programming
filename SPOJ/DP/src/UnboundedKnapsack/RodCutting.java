package UnboundedKnapsack;

import java.util.Arrays;

public class RodCutting {

	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length[] = {1,2,3,4,5,6,7,8};
		int profit[] = {1,5,8,9,10,17,17,20};
		int target =10;
		int n = length.length;
		
		System.out.println(RodCut(length,profit,0,target,profit.length));
		memo=new int[n+1][target+1];
		for(int i[]: memo) {
			Arrays.fill(i,-1);
		}
		
		System.out.println(RodCutMemo(length,profit,0,target,profit.length));
		for(int i=0; i<=n;i++) {
			for(int j=0;j<=target;j++) {
				System.out.print(memo[i][j]+"       ");
			}
			System.out.println();
		}
		
		System.out.println(RodCutDp(length,profit,0,target,profit.length));
	}

	private static int RodCut(int[] length,int profit[], int curProfit, int target, int n) {
		// TODO Auto-generated method stub
		
		if(target==0) {
			return curProfit;
		}
		
		if(n<=0 || target<0)
			return 0;
		
		if(length[n-1]>target) {
			return RodCut(length,profit,curProfit,target,n-1);
		}else {
			
			int choose = RodCut(length,profit,curProfit+profit[n-1],target-length[n-1],n);
			int notChoose =	RodCut(length,profit,curProfit,target,n-1);	
			
			return Math.max(choose, notChoose);
		}		
	}
	
	private static int RodCutMemo(int[] length,int profit[], int curProfit, int target, int n) {
		// TODO Auto-generated method stub
		
		if(target==0) {
			return curProfit;
		}
		
		if(n<=0 || target<0)
			return 0;
		
		if(memo[n][target]!=-1)
			return memo[n][target];
		
		if(length[n-1]>target) {
			return  memo[n][target]=RodCutMemo(length,profit,curProfit,target,n-1);
		}else
		{
			
			int choose = profit[n-1]+RodCutMemo(length,profit,curProfit,target-length[n-1],n);
			int notChoose =	RodCutMemo(length,profit,curProfit,target,n-1);	
			
			return  memo[n][target]=Math.max(choose, notChoose);
		}		
	}
	
	
	private static int RodCutDp(int[] length,int profit[], int curProfit, int target, int n) {
		
		int dp[][] = new int[n+1][target+1];
		
		for(int i=0;i<=n;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<=target;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1; i<=n;i++) {
			for(int j=1;j<=target;j++) {
				if(length[i-1]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]= Math.max(dp[i-1][j], profit[i-1] + dp[i][j-length[i-1]]);
			}
		}
		
		System.out.println("***************************");
		
		for(int i=0; i<=n;i++) {
			for(int j=0;j<=target;j++) {
				System.out.print(dp[i][j]+"       ");
			}
			System.out.println();
		}
		
		return dp[n][target];
	}
}
