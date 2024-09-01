class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int n1=arr1.size(), n2=arr2.size();
        int i=n1-1, j=n2-1, ans=0, sum1=0, sum2=0;
        
        while(i>=0 && j>=0) {
            if(arr1.get(i) > arr2.get(j)){
                sum1+=arr1.get(i--);
            }
            else if(arr2.get(j) > arr1.get(i)) {
                sum2+=arr2.get(j--);
            }
            else {
                ans+=arr1.get(i--); j--;
                ans+=Math.max(sum1, sum2);
                sum1=0; sum2=0;
            }
        }
        
        while(j>=0) sum2+=arr2.get(j--);
        while(i>=0) sum1+=arr1.get(i--);
        ans+=Math.max(sum1, sum2);
        
        return ans;
    }
}