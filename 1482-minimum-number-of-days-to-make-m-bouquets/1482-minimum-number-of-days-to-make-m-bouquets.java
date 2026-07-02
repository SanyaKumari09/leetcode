class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1; 

        int low = findMin(bloomDay);
        int high = findMax(bloomDay);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(possible(bloomDay, mid, m, k)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
} 


private int findMax(int[] bloomDay) {
    int max = Integer.MIN_VALUE;
    for (int day : bloomDay) {
        max = Math.max(max, day);
    }
    return max;
}

private int findMin(int[] bloomDay) {
    int min = Integer.MAX_VALUE;
    for (int day : bloomDay) {
        min = Math.min(min, day);
    }
    return min;
}

private boolean possible(int[] bloomDay, int days, int m, int k){
   int bouquets=0;
   int cnt=0;
   int n = bloomDay.length;
   for(int i=0; i<n; i++){
     if(bloomDay[i]<=days){
        cnt++;
        if(cnt == k ){
            bouquets++;
            cnt=0;
        }
     }else{
        cnt=0;
    }
   }
   return bouquets >= m;
}
}



