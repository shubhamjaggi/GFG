class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int left=0, right=0;
        Map<Character,Integer> countMap = new HashMap<>();
        int ans=-1;
        
        while(right<s.length()) {
            char rightCh = s.charAt(right);
            countMap.put(rightCh, countMap.getOrDefault(rightCh,0)+1);
            while(countMap.size()>k) {
                char leftCh = s.charAt(left);
                countMap.put(leftCh, countMap.get(leftCh)-1);
                if(countMap.get(leftCh)==0) countMap.remove(leftCh);
                left++;
            }
            
            if(countMap.size()==k) ans=Math.max(ans,right-left+1);
            right++;
        }
        
        return ans;
    }
}