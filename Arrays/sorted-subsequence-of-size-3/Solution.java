class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        int minLeft = 0;
        int[] minLeftArr = new int[arr.length];
        Arrays.fill(minLeftArr, -1);
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > arr[minLeft]) minLeftArr[i] = minLeft;
            else minLeft = i;
        }
        
        int maxRight = arr.length-1;
        int[] maxRightArr = new int[arr.length];
        Arrays.fill(maxRightArr, arr.length);
        
        for(int i=arr.length-2; i>=0; i--) {
            if(arr[i] < arr[maxRight]) maxRightArr[i] = maxRight;
            else maxRight = i;
        }
        
        for(int i=0; i < arr.length; i++) {
            if (minLeftArr[i] != -1 && maxRightArr[i] != arr.length) {
                return Arrays.asList(arr[minLeftArr[i]], arr[i], arr[maxRightArr[i]]);
            }
        }
        
        return new ArrayList<>();
    }
}