class Solution {

    public List<Integer> genRows(int rows) {
       int ans=1;
       List<Integer> singleRow = new ArrayList<>();
       singleRow.add(1);
       for(int col=1;col<rows;col++){
         ans = ans*(rows-col);
         ans = ans/col;
         singleRow.add(ans);
       }
       return singleRow;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1 ; i<=numRows ; i++){
            result.add(genRows(i));
        }
        return result;
    }
}