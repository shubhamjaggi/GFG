class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int candidate = a[0];
        int count = 1;
        
        for (int i = 1; i < size; i++) {
            if (candidate == a[i]) {
                count++;
            }
            else {
                if (count == 1) {
                    candidate = a[i];
                }
                else {
                    count--;
                }
            }
        }
        
        final int finalCandidate = candidate;
        
        return Arrays.stream(a).filter(x -> x == finalCandidate).count() > (size/2) ? candidate : -1;
    }
}