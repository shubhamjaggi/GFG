
//User function Template for Java

class Solution { 
    int minSubset(int[] Arr,int N) { 
        Arr = Arrays.stream(Arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(a->a).toArray();
        long remSum = Arrays.stream(Arr).mapToLong(a->a).sum();
        long subsetSum = 0L;
        for(int i=0; i<N; i++){
            subsetSum+=Arr[i];
            remSum-=Arr[i];
            if(subsetSum>remSum) return i+1;
        }
        return 0;
    }
}