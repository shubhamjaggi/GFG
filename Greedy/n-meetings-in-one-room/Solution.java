
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n){
        int[][] meetings = new int[n][3];
        
        for(int i=0; i<n; i++){
            meetings[i][0] = i;
            meetings[i][1] = start[i];
            meetings[i][2] = end[i];
        }
        
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        
        int count = 0;
        
        for(int i=0; i<n;){
            count++;
            int endTime = meetings[i][2];
            i++;
            while(i<n && endTime>=meetings[i][1]){
                i++;
            }
        }
        
        return count;
    }
}