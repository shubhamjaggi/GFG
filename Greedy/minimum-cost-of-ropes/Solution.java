
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        if(n==1) return 0L;
        Queue<Long> values = Arrays.stream(arr).boxed().collect(java.util.stream.Collectors.toCollection(PriorityQueue::new));
        long res = 0;
        for(int i=1; i<=n-1; i++){
            long joinedLen = values.poll() + values.poll();
            values.offer(joinedLen);
            res+=joinedLen;
        }
        return res;
    }
}