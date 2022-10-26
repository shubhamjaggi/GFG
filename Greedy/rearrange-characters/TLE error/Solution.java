class Solution
{
	public static String rearrangeCharacters(String str) {
	    Queue<Map.Entry<Character, Long>> config = Arrays.stream(str.split("")).map(a->a.charAt(0)).collect(java.util.stream.Collectors.groupingBy(a->a, HashMap::new, java.util.stream.Collectors.counting())).entrySet().stream().collect(java.util.stream.Collectors.toCollection(() -> new PriorityQueue<Map.Entry<Character, Long>>(Comparator.<Map.Entry<Character, Long>, Long>comparing(a->a.getValue()).reversed())));
	    StringBuilder resBuilder = new StringBuilder();
	    Map.Entry<Character, Long> prev = null;
	    while(!config.isEmpty()){
	        Map.Entry<Character, Long> ch = config.poll();
	        resBuilder.append(ch.getKey());
	        if(prev!=null && prev.getValue()>0L) config.offer(prev);
	        ch.setValue(ch.getValue()-1L);
	        prev = ch;
	    }
	    String res = resBuilder.toString();
	    if(res.length()==str.length()) return res;
	    return "-1";
	}
}