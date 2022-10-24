
/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n){
        // Your code here
        Arrays.sort(arr, Comparator.<Item, Double>comparing(a->((double)a.value/(double)a.weight)).reversed());
        double ans = 0;
        int i;
        int remainingCapacity = W;
        for(i=0; i<n && remainingCapacity>=arr[i].weight; i++){
            ans+=(arr[i].value);
            remainingCapacity-=arr[i].weight;
        }
        if(i<n){
            ans+=(((double)arr[i].value)*(((double)remainingCapacity)/((double)arr[i].weight)));
        }
        return ans;
    }
}