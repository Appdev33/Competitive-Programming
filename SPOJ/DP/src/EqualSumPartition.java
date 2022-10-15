import java.util.Arrays;

public class EqualSumPartition {

	static int memo[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = { 1, 5, 11, 5,6 };
		int sum = 0;

		for (int i : ar)
			sum += i;

		if (sum % 2 != 0)
			System.out.println(false);
		else {
			memo = new int[ar.length + 1][sum / 2 + 1];
			for (int arr[] : memo)
				Arrays.fill(arr, -1);
//			 System.out.println(helper(ar,sum/2,ar.length) );
//			 System.out.println(helperMemo(ar,sum/2,ar.length) );

			System.out.println(helperDP(ar, sum / 2, ar.length));
		}
	}

	public static boolean helper(int ar[], int target, int n) {

		if (n == 0)
			return false;

		if (target == 0)
			return true;

		if (ar[n - 1] > target)
			return helper(ar, target, n - 1);
		else
			return helper(ar, target - ar[n - 1], n - 1) || helper(ar, target, n - 1);

	}

	public int helperMemo(int ar[], int target, int n) {

		if (n == 0)
			return 0;

		if (target == 0)
			return 1;

		if (memo[n][target] != -1)
			return memo[n][target];

		if (ar[n - 1] > target)
			return memo[n][target] = helperMemo(ar, target, n - 1);
		else
			return memo[n][target] = helperMemo(ar, target - ar[n - 1], n - 1) | helperMemo(ar, target, n - 1);

	}

	public static int helperDP(int arr[], int sum, int N) {
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
					dp[i][j] = dp[i - 1][j - arr[i - 1]] | dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[N][sum];

	}
}
