class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer>[] bucket = new ArrayList[n+1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            int el = entry.getKey();
            int freq = entry.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(el);
        }

        int[] ans = new int[k];
        int index = 0;

        for(int freq = n; freq >= 1 && index < k; freq--){
          if(bucket[freq] != null){
            for(int num : bucket[freq]){
                ans[index] = num;
                index++;
            }
            if(index == k){
                break;
            }
          }
        }

        return ans;
        
    }
}