class Solution {
    public boolean checkPerfectNumber(int num) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=1; i<=num/2 ;i++){
           if(num%i==0){
            res.add(i);
           }
        }
        int sum=0;
        for(int i: res){
            sum+=i;
        }

        if(sum == num){
            return true;
        }

        return false;
    }
}