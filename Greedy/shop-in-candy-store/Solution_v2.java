class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        // code here
        Arrays.sort(candies);
        int min=0, max=0;
        
        
        int i=0, j=N-1;
        while(i<=j) {
            min+=candies[i];
            i++; j-=K;
        }
        
        i=N-1; j=0;
        while(i>=j) {
            max+=candies[i];
            i--; j+=K;
        }
        
        return new ArrayList<>(Arrays.asList(min, max));
    }
}