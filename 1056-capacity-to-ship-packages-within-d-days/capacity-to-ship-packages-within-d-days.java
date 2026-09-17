import java.util.*;
class Solution {

    public static boolean possible(int[] weights, int mid , int days){
        int sum=0;
        int count = 1;

        for(int i=0;i<weights.length;i++){
            if(sum + weights[i] > mid){
                count++;
                sum = weights[i];
            }else{
                sum += weights[i];
            }
        }
        return count<=days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        int ans =0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}