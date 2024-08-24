class Solution
{
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   Set<Integer> nums = new HashSet<>();
	   for (int i = 0; i < N; i++) nums.add(arr[i]);
	   
	   int maxCount = 0;
	   
	   for(int x : arr) {
	       if(!nums.contains(x-1)) {
	           int count = 0;
	           for(int i = x; nums.contains(i); i++) count++;
	           maxCount = Math.max(count, maxCount);
	       }
	   }
	   
	   return maxCount;
	}
}