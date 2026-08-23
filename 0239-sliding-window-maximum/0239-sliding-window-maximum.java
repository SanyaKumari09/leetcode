class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int index=0;

        Deque<Integer> deq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            //Check if the index is expired or not i.e out of the current needed window
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.removeFirst();
            }

            //Check if the el from back is smaller than curr el
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]){
                deq.removeLast();
            }

            deq.addLast(i);

            //And if window is ready just put the ans in the res array
            if(i >= k-1){
                res[index++] = nums[deq.peekFirst()];
            }
        }

        return res;
    }
}