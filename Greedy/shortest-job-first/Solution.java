class Solution {
    static int solve(int bt[] ) {
        Arrays.sort(bt);
        int totWaitTime=0, currTime=0;
        for(int t : bt) {
            totWaitTime+=currTime;
            currTime+=t;
        }
        return totWaitTime/bt.length;
    }
}