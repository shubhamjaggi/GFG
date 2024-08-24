class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
        Map<Long, Integer> numsMap = new HashMap<>();
        
        for(int i=0; i < n; i++) {
            if (numsMap.containsKey(a1[i])) {
                numsMap.put(a1[i], numsMap.get(a1[i]) + 1);
            }
            else {
                numsMap.put(a1[i], 1);
            }
        }
        
        for (int i=0; i < m; i++) {
            if (!numsMap.containsKey(a2[i])) return "No";
            if(numsMap.get(a2[i]) == 1) {
                numsMap.remove(a2[i]);
            }
            else {
                numsMap.put(a1[i], numsMap.get(a1[i]) - 1);
            }
        }
        
        return "Yes";
    }
}