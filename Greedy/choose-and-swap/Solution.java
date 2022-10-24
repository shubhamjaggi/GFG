
//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
        // Code Here
        TreeSet<Character> charSet = new TreeSet<>();
        char[] chars = A.toCharArray();
        for(char ch : chars){
            charSet.add(ch);
        }
        for(int i=0; i<chars.length && charSet.size()>1; i++){
            char curr = chars[i];
            charSet.remove(curr);
            char lowestCharAhead = charSet.first();
            if(lowestCharAhead<curr){
                for(int j=i; j<chars.length; j++){
                    if(chars[j]==lowestCharAhead){
                        chars[j]=curr;
                    }else if(chars[j]==curr){
                        chars[j]=lowestCharAhead;
                    }
                }
                return String.valueOf(chars);
            }
        }
        return A;
    }
    
}