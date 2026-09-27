class Solution {

    public static boolean possible(int[] nums, int mid , int k){
        int sum =0;
        int j=1;

        for(int i=0 ; i< nums.length ; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                j++;
                sum = nums[i];
            }
        }
        return j<=k;
    }
    
    public int splitArray(int[] nums, int k) {
        if(k > nums.length){
            return -1;
        }

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(nums, mid , k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}