class StockSpanner {

    Stack<Integer> st;
    ArrayList<Integer> prices;

    public StockSpanner() {
        st = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        int i = prices.size();

        while(!st.isEmpty() && prices.get(st.peek()) <= price){
            st.pop();
        }

        int span;

        if(st.isEmpty()){
            span = i+1;
        }else{
            span = i - st.peek();
        }

        prices.add(price);
        st.push(i);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */