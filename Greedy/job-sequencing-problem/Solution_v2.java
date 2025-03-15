class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        int n = id.length;
        JobWrapper[] jobs = new JobWrapper[n];
        
        for(int i=0; i<n; i++) {
            jobs[i] = new JobWrapper(id[i], deadline[i], profit[i]);
        }
        
        Arrays.sort(jobs, Comparator.comparing(JobWrapper::getProfit).reversed()); // decreasing order based on the profit
        
        int numJobs=0;
        int totProfit=0;
        Integer[] jobSeq = new Integer[n];
        
        for(int i=0; i<n; i++) {
            for(int j=Math.min(n, jobs[i].deadline)-1; j>=0; j--) {
                if(jobSeq[j] == null) {
                    jobSeq[j] = jobs[i].id;
                    numJobs++;
                    totProfit+=jobs[i].profit;
                    break;
                }
            }
        }
        
        return new ArrayList<Integer>(Arrays.asList(numJobs, totProfit));
        
    }
}

class JobWrapper {
    int id;
    int deadline;
    int profit;
    
    JobWrapper(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
    
    int getProfit() { return this.profit; } // for use with comparator
}