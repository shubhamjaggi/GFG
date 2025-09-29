class Solution {
    public String findOrder(String[] words) {
        // find total number of characters required in the answer String
        Set<Character> charSet=new HashSet<>();
        for(String word:words) {
            for(char ch:word.toCharArray()) charSet.add(ch);
        }
        int numChars=charSet.size();
        
        // create adjacency list (map in this case as we have character nodes)
        Map<Character,List<Character>> adj = new HashMap<>();
        for(char ch: charSet) adj.put(ch,new ArrayList<>());
        for(int i=0;i<words.length-1;i++) {
            String word1=words[i]; String word2=words[i+1];
            // find first differing character
            int smallerLen=Math.min(word1.length(),word2.length());
            
            boolean foundDiff=false;
            for(int j=0;j<smallerLen;j++) {
                char ch1=word1.charAt(j); char ch2=word2.charAt(j);
                if(ch1!=ch2) {
                    foundDiff=true;
                    adj.get(ch1).add(ch2);
                    break; // only first differing character needs to be considered
                }
            }
            
            if(!foundDiff && word1.length()>word2.length()) return ""; // handle invalid inputs like abc ab => ab should be before abc in valid dictionary
        }
        
        
        // detecy cycle and create topological stack
        Map<Character,Boolean> vis=new HashMap<>();
        Map<Character,Boolean> rec=new HashMap<>();
        for(char ch: charSet) {
            vis.put(ch,false);
            rec.put(ch,false);
        }
        Stack<Character> topoStack = new Stack<>();
        for(char ch:charSet) {
            if(!vis.get(ch)) {
                if(isCycleUsingTopoDfs(ch,adj,vis,rec,topoStack)) return ""; // cycle exists
            }
        }
        
        // create answer string from topological stack
        char[] ans = new char[numChars];
        int ind=0;
        while(!topoStack.isEmpty()) ans[ind++]=topoStack.pop();
        return String.valueOf(ans);
    }
    
    private boolean isCycleUsingTopoDfs(char ch, Map<Character,List<Character>> adj, Map<Character,Boolean> vis, Map<Character,Boolean> rec, Stack<Character> topoStack) {
        vis.put(ch,true);
        rec.put(ch,true);
        for(char nei:adj.get(ch)) {
            if(!vis.get(nei)) {
                if(isCycleUsingTopoDfs(nei,adj,vis,rec,topoStack)) return true;
            } else if(rec.get(nei)) return true;
        }
        rec.put(ch,false);
        topoStack.push(ch);
        return false;
    }
}