import java.util.*;
class Solution {

    public static boolean canMakeBouquets(int[] bloomDay,int day, int m, int k){
        int flowers =0;
        int bouquets =0;

        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i] <= day){
                flowers++;
                if(flowers == k){
                    bouquets++;
                    flowers =0;
                }
            }else{
                    flowers =0;
            }
        }
        return bouquets>=m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length){
            return -1;
        }
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while(low <= high){
            int mid = (low + high)/2;

            if(canMakeBouquets(bloomDay,mid,m,k)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}