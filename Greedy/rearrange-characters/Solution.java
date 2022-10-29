class Solution
{
	public static String rearrangeCharacters(String str) {
	    int[] preProcData = new int[26];
	    for(int i=0; i<str.length(); i++) preProcData[str.charAt(i)-'a']++;
	    Queue<CharCount> confQueue = new PriorityQueue<>(Comparator.<CharCount, Integer>comparing(a->a.count).reversed());
	    for(int i=0; i<26; i++){
	        if(preProcData[i]>0){
	            CharCount cc = new CharCount();
	            cc.ch = (char)(i+(int)'a');
	            cc.count = preProcData[i];
	            confQueue.offer(cc);
	        }
	    }
	    StringBuilder resBuilder = new StringBuilder();
	    CharCount prev = null;
	    while(!confQueue.isEmpty()){
	        CharCount cc = confQueue.poll();
	        resBuilder.append(cc.ch);
	        if(prev!=null && prev.count>0) confQueue.offer(prev);
	        cc.count--;
	        prev = cc;
	    }
	    String res = resBuilder.toString();
	    if(res.length()==str.length()) return res;
	    return "-1";
	}
	
	static class CharCount{
	    char ch;
	    int count;
	}
}