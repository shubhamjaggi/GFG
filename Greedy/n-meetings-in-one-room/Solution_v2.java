class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Meeting[] meetings = new Meeting[n];
        
        for(int i=0; i<n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }
        
        Arrays.sort(meetings, Comparator.comparing(Meeting::getEnd));
        
        int res = 1; // to include 0th meeting from the sorted array
        int currTime = meetings[0].end; // 1 meeting completed
        
        for(int i=1; i<n; i++) {
            if (meetings[i].start > currTime) {
                res++;
                currTime = meetings[i].end;
            }
        }
        
        return res;
    }
}

class Meeting {
    int start;
    int end;
    
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    int getEnd() { return end; } // for use with comparator
}