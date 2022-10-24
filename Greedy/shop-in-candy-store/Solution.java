
//User function Template for Java


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        
        int min=0, max=0;
        int s = 0, e = N-1;
        
        for(int i=0; i<=e; i++){
            min+=candies[i];
            e-=Math.min(K, e-i);
        }
        
        for(int i=N-1; i>=s; i--){
            max+=candies[i];
            s+=Math.min(K, i-s);
        }
        
        return java.util.stream.Stream.of(min, max).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
    }
}