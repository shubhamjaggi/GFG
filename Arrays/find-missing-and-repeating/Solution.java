class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long naturalSum = prod(n, n+1)/2;
        long diff = Arrays.stream(arr).mapToLong(a->(long)a).sum() - naturalSum;
        long sqNaturalSum=0L;
        for (int i=1; i<=n; i++) sqNaturalSum+=prod(i,i);
        long sqDiff = Arrays.stream(arr).mapToLong(a->prod(a,a)).sum() - sqNaturalSum;
        long sum = sqDiff/diff;
        int[] ans = {(int)((sum+diff)/2), (int)((sum-diff)/2)};
        return ans;
    }
    
    private long prod(long i, long j) { return i*j;}