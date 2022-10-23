
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, Comparator.<Job, Integer>comparing(a -> a.profit).reversed());
        int[] res = new int[2];
        int[] config = new int[n];
        for(Job job : arr){
            int ind;
            for(ind = Math.min(n, job.deadline)-1; ind>=0 && config[ind]==1; ind--);
            if(ind>=0){
                config[ind]=1;
                res[0]++;
                res[1]+=job.profit;
            }
        }
        return res;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/