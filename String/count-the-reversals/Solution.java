class Sol
{
    int countRev (String s)
    {
        if(s.length()%2 == 1) return -1;
        int extraOpen = 0, extraClose = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{') extraOpen++;
            else {
                if(extraOpen==0) extraClose++;
                else extraOpen--;
            }
        }
        
        return (int)(Math.ceil(extraOpen/2.0) + Math.ceil(extraClose/2.0));
    }
}