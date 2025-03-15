class Solution {

    String chooseandswap(String str) {
        char[] chars = str.toCharArray();
        
        TreeSet<Character> cs = new TreeSet<>();
        for(char ch : chars) cs.add(ch);
        
        for(int i=0; i<str.length() && cs.size()>=2; i++) {
            char curr = str.charAt(i);
            cs.remove(curr);
            char smallestAhead = cs.first();
            if(curr > smallestAhead) {
                for(int j=i; j<str.length(); j++) {
                    if (chars[j] == smallestAhead) chars[j]=curr;
                    else if (chars[j] == curr) chars[j]=smallestAhead;
                }
                return String.valueOf(chars);
            }
        }
        return str;
    }
}