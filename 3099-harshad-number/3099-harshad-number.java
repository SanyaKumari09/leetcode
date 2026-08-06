class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int org = x;
        int dig=0;
        int sum=0;
        while(x>0){
            dig=x%10;
            sum+=dig;
            x=x/10;
        }

        if(org%sum==0){
            return sum;
        }

        return -1;
    }
}