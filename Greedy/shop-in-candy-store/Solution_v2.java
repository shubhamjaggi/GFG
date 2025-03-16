class Solution{
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        int i=0, j=N-1;
        int min=0, max=0;
        
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