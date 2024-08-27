class Solution
{
    public int[][] overlappedInterval(int[][] a)
    {
        int n = a.length;
        Arrays.sort(a, Comparator.comparing(arr -> arr[0]));
        int[][] x = new int[n][2];
        
        x[0] = a[0];
        int count = 1;
        for(int i = 1, j = 0; i < n; i++) {
            if(x[j][1] >= a[i][0]) x[j][1] = Math.max(x[j][1], a[i][1]);
            else {
                x[++j] = a[i];
                count++;
            }
        }
        
        int[][] ans = new int[count][2];
        while(count > 0) ans[count-1] = x[--count];
        return ans;
    }
}