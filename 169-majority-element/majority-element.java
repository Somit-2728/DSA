class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int element = 0;
        int maxElement =-1;
        for(int i=0;i<nums.length;i++){
            if(count == 0){
                element = nums[i];
                count =1;
            }
            else if(nums[i] == element){
                count++;
            }else{
                count--;
            }
        }

        if(count != 0){
            maxElement = element;
            count =0; 
        }
        count =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == maxElement){
                count++;
            }
        }
        if(count > nums.length/2){
                return maxElement;
        }
        return -1;
    }
}