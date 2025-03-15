class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        Item[] items = new Item[val.size()];
        for (int i=0; i<val.size(); i++) items[i] = new Item(val.get(i), wt.get(i));
        Arrays.sort(items, Comparator.comparing(Item::valByWt).reversed());
        
        double res=0;
        int capacityLeft = capacity;
        
        for(Item item : items) {
            if(item.wt <= capacityLeft) {
                res+=item.val;
                capacityLeft-=item.wt;
            }
            else {
                res+=(item.val*(((double)capacityLeft)/((double)item.wt)));
                capacityLeft=0;
                break;
            }
        }
        
        return res;
    }
}

class Item {
    int val;
    int wt;
    
    Item(int val, int wt) {
        this.val=val;
        this.wt=wt;
    }
    
    double valByWt() { return ((double)val)/((double)wt); }
}