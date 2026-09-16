import java.util.*;
class Solution {

    public static boolean find(int[] nums, int mid , int threshold){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += (int)Math.ceil((double) nums[i]/mid);            
        }
        if(sum <= threshold){
            return true;
        }else{
            return false;
        }
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low <= high){
            int mid = low + (high-low)/2;
            if(find(nums,mid,threshold)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}