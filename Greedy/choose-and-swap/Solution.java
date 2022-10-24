
//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
        // Code Here
        Set<Character> charSet = new TreeSet<>();
        char[] chars = A.toCharArray();
        for(char ch : chars){
            charSet.add(ch);
        }
        for(int i=0; i<chars.length; i++){
            char ch = chars[i];
            charSet.remove(ch);
            for(char chs : charSet){
                if(chs<ch){
                    for(int j=i; j<chars.length; j++){
                        if(chars[j]==chs){
                            chars[j]=ch;
                        }else if(chars[j]==ch){
                            chars[j]=chs;
                        }
                    }
                    return String.valueOf(chars);
                }
            }
        }
        return A;
    }
    
}