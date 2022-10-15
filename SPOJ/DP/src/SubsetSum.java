import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

	static int tab[][];
	public static void main(String[] args) {
		
		int ar[] = {3,4,5,7,10};
		int sum = 13;
		int n = ar.length;
		
		System.out.println(subsetSumR(ar, n-1, sum));
		
		// create a map to store solutions to subproblems
        Map<String, Boolean> lookup = new HashMap<>();
        
		System.out.println(subsetSum(ar, ar.length - 1, sum, lookup));
		
//		System.out.println(dpsubSetSum(ar,n,sum));
	}
	
	 static boolean subsetSumR(int[] A, int n, int k)
    {
        // return true if the sum becomes 0 (subset found)
        if (k == 0) {
            return true;
        }
 
        // base case: no items left, or sum becomes negative
        if (n < 0 || k < 0) {
            return false;
        }
 
        // Case 1. Include the current item `A[n]` in the subset and recur
        // for the remaining items `n-1` with the remaining total `k-A[n]`
        boolean include = subsetSumR(A, n - 1, k - A[n]);
 
        // Case 2. Exclude the current item `A[n]` from the subset and recur for
        // the remaining items `n-1`
        boolean exclude = subsetSumR(A, n - 1, k);
 
        // return true if we can get subset by including or excluding the
        // current item
        return include || exclude;
    }
 
	
//	static boolean isSubsetSum(int set[],
//            int n, int sum)
//	{
//		// Base Cases
//		if (sum == 0)
//			return true;
//		if (n == 0)
//			return false;
//		
//		// If last element is greater than
//		// sum, then ignore it
//		if (set[n - 1] > sum)
//			return isSubsetSum(set, n - 1, sum);
//		
//		/* else, check if sum can be obtained 
//		by any of the following
//		(a) including the last element
//		(b) excluding the last element */
//		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
//	}
	
	 
	 public static boolean subsetSum(int[] A, int n, int k, Map<String, Boolean> lookup)
	    {
	        // return true if the sum becomes 0 (subset found)
	        if (k == 0) {
	            return true;
	        }
	 
	        // base case: no items left, or sum becomes negative
	        if (n < 0 || k < 0) {
	            return false;
	        }
	 
	        // construct a unique map key from dynamic elements of the input
	        String key = n + "|" + k;
	 
	        // if the subproblem is seen for the first time, solve it and
	        // store its result in a map
	        if (!lookup.containsKey(key))
	        {
	            // Case 1. Include the current item `A[n]` in the subset and recur
	            // for the remaining items `n-1` with the decreased total `k-A[n]`
	            boolean include = subsetSum(A, n - 1, k - A[n], lookup);
	 
	            // Case 2. Exclude the current item `A[n]` from the subset and recur for
	            // the remaining items `n-1`
	            boolean exclude = subsetSum(A, n - 1, k, lookup);
	 
	            // assign true if we get subset by including or excluding
	            // current item
	            lookup.put(key, include || exclude);
	        }
	 
	        // return solution to the current subproblem
	        return lookup.get(key);
	    }
	
	static boolean dpsubSetSum(int ar[],int n,int sum) {
		
		boolean dp[][] = new boolean[n+1][sum+1];
		
		for(int i=0;i<=n;i++)
			dp[i][0]=true;
		
//		for(int j=1;j<=sum;j++)
//			dp[0][j]=false;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(ar[i-1]>j) 
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j-ar[i-1]] || dp[i-1][j]  ;
			}
		}
		return dp[n][sum];
	}
	
	

	  
}
