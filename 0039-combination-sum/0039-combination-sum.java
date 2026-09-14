class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(candidates, n, 0, curr, ans, target);
        return ans;
    }

    public void backtrack(int[] arr, int n, int index, List<Integer>curr, List<List<Integer>> ans, int target){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(index == n || target < 0){
            return;
        }

         //Dont opt the element
        backtrack(arr, n, index+1, curr, ans, target);

        //Take the element
        curr.add(arr[index]);
        backtrack(arr, n, index, curr, ans, target-arr[index]);
        curr.remove(curr.size() - 1);
    }
}