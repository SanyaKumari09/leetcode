class MinStack {

    private Stack<Long> st;
    private long mini;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        if (st.isEmpty()) {
            mini = value;
            st.push((long) value);
            return;
        }

        if (value > mini) {
            st.push((long) value);
        } 
        else {
            st.push(2L * value - mini);
            mini = value;
        }
    }

    public void pop() {

        if (st.isEmpty()) {
            return;
        }

        long x = st.pop();

        if (x < mini) {
            mini = 2 * mini - x;
        }
    }

    public int top() {

        if (st.isEmpty()) {
            return -1;
        }

        long x = st.peek();

        if (x < mini) {
            return (int) mini;
        }

        return (int) x;
    }

    public int getMin() {
        return (int) mini;
    }
}