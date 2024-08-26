class Solution {
    public static int doUnion(int arr1[], int arr2[]) {
        // Your code here
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr1).forEach(set::add);
        Arrays.stream(arr2).forEach(set::add);
        return set.size();
    }
}