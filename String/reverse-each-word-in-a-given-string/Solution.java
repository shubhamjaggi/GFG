class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        char[] chars = S.toCharArray();
        int beg = nextWordBegInd(chars, 0); int end = beg;
        while(beg < chars.length) {
            end = wordEndInd(chars, beg);
            reverseChars(chars, beg, end);
            beg = nextWordBegInd(chars, end + 1);
        }
        
        return String.valueOf(chars);
    }
    
    private int nextWordBegInd(char[] chars, int i) {
        while(i < chars.length && chars[i] == '.') i++;
        return i;
    }
    
    private int wordEndInd(char[] chars, int i) {
        while(i < chars.length && chars[i] != '.') i++;
        return i-1;
    }
    
    private void reverseChars(char[] chars, int i, int j) {
        int mid = (i+j)/2;
        for(int x = i; x <= mid; x++) swap(chars, x, j-(x-i));
    }
    
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}