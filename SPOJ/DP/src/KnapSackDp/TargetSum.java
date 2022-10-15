package KnapSackDp;

public class TargetSum {

	public static void main(String[] args) {
		// Problems same as subset diff  (s1)-(s2)=k
		int ar[] = {1,1,2,3};
		int target = 1;
		int sumTotal =0;
		for(int i: ar)
			sumTotal+=i;
		
		System.out.println( CountSubsetGivenDiff.CountSubsetDP(ar,target,ar.length,sumTotal) );
	}

}
