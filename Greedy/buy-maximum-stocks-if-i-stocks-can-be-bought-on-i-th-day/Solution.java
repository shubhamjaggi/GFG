
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        int[][] conf = new int[n][2];
        for(int i=0; i<n; i++){
            conf[i][0] = i+1;
            conf[i][1] = price[i];
        }
        Arrays.sort(conf, Comparator.comparing(a -> a[1]));
        int res = 0;
        for(int i=0; i<n && k>0; i++){
            int numStocks = Math.min(k/conf[i][1], conf[i][0]);
            k-=(numStocks*conf[i][1]);
            res+=numStocks;
        }
        return res;
    }
}