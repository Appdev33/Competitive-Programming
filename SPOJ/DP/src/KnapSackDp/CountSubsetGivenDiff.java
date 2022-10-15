package KnapSackDp;

public class CountSubsetGivenDiff {
	
	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ar[] = {1, 2, 3, 1, 2};
		int k=1;
		int sumTotal=0;
		
		for(int i: ar)
			sumTotal+=i;
		
		System.out.println( CountSubset(ar,k,ar.length,0,sumTotal) );
		System.out.println( CountSubsetDP(ar,k,ar.length,sumTotal) );
	}

	private static int CountSubset(int[] ar, int k, int n,int sumCalculated,int sumTotal) {

		if(n==0) {
			if(sumCalculated==(sumTotal+k)/2)
				return 1;
			else
				return 0;
		}
			
		int take =	CountSubset(ar,k,n-1,sumCalculated+ar[n-1],sumTotal);
		int dontTake = CountSubset(ar,k,n-1,sumCalculated,sumTotal);
		
		return take+dontTake;
	}
	
	
	public static int CountSubsetDP(int ar[], int k,int n,int sumTotal) {
		
		int subset2 = (k+sumTotal)/2;
		
		return CountSubsetSum.CountSubsetSumDP(ar,subset2,n);	
	}

}
