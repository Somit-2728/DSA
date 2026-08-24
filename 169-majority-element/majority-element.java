class Solution {
    public int majorityElement(int[] nums) {
        int element=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(count== 0){
                element = nums[i];
                count=1;
            }

            else if(nums[i] == element){
                count++;
            }else{
                count--;
            }
        }
        int major =0;

        if(count != 0){
            major = element;
            count =0;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] == major){
                count++;
            }
        }
        if(count > nums.length/2){
            return major;
        }else{
            return -1;
        }
    }
}