class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        StockConfig[] stockConfigs = new StockConfig[n];
        for(int i=0; i<n; i++) stockConfigs[i] = new StockConfig(i+1, price[i]);
        Arrays.sort(stockConfigs, Comparator.comparing(StockConfig::getPrice));
        int remainingAmount=k; int totStocks=0;
        for(StockConfig stockConfig : stockConfigs) {
            int priceAllCurr=(stockConfig.price*stockConfig.numStocks);
            if(remainingAmount>=priceAllCurr) {
                totStocks+=stockConfig.numStocks;
                remainingAmount-=priceAllCurr;
            }
            else {
                totStocks+=(remainingAmount/stockConfig.price);
                break;
            }
        }
        return totStocks;
    }
}

class StockConfig {
    int numStocks;
    int price;
    
    StockConfig(int numStocks, int price) {
        this.numStocks = numStocks;
        this.price = price;
    }
    
    int getPrice() { return this.price; }
    
}