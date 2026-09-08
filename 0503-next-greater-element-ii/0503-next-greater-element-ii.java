class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int res[] = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--){
            int index = i%n;
            while(!st.isEmpty() && st.peek() <= nums[index]){
                st.pop();
            }

            if(i<n){
                if(!st.isEmpty()){
                    res[i] = st.peek();
                }
            }
            st.push(nums[index]);
        }

        return res;
    }
}