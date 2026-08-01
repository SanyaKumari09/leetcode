class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int answer=0;
        int s=0;
        int[] prefSum = new int[n];
        for(int i=0;i<n;i++){
            s+=arr[i];
            prefSum[i]=s;
        }
    
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int len=j-i+1;

                if(len%2!=0){
                    if(i==0){
                        sum=prefSum[j];
                    }else{
                        sum=prefSum[j]-prefSum[i-1];
                    }
                    answer+=sum;
                }
            }
        }

        return answer;
    }
}