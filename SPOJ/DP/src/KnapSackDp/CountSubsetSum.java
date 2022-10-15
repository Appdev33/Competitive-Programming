package KnapSackDp;

import java.util.Arrays;

public class CountSubsetSum {
	
	static int memo[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3, 3, 3, 3};
		int sum =6;
		int n = arr.length;
		
		memo = new int[sum+1][n+1];
//		System.out.println(CountSubsetSum(arr,sum,n) );
//		for(int a[]: memo)
//			Arrays.fill(a, -1);
//		System.out.println(CountSubsetSumMemo(arr,sum,n) );
		System.out.println(CountSubsetSumDP(arr,sum,n) );
		
	}

	private static int CountSubsetSum(int[] arr, int sum,int n) {
		if(sum==0) {
			return 1;
		}
		
		if(n<=0 || sum<0) {
			return 0;
		}
		
		if(memo[sum][n]!=-1)
			return memo[sum][n]; 
		
		if(arr[n-1]>sum)
			return memo[sum][n] =CountSubsetSum(arr,sum,n-1);
		
		return memo[sum][n] = CountSubsetSum(arr,sum,n-1) +	CountSubsetSum(arr,sum-arr[n-1],n-1);
	}
	
	private static int CountSubsetSumMemo(int[] arr, int sum,int n) {

		if(sum==0) {
			return 1;
		}
		
		if(n<=0 || sum<0) {
			return 0;
		}
		
		if(arr[n-1]>sum)
			return CountSubsetSum(arr,sum,n-1);
		
		return CountSubsetSum(arr,sum,n-1) +	CountSubsetSum(arr,sum-arr[n-1],n-1);
	}
	
	static int CountSubsetSumDP(int[] arr, int sum,int N) {
		int dp[][] = new int[N + 1][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i < N + 1; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][sum];
	}
}
