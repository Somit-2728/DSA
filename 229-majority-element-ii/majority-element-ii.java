class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = 0;
        int ele2 =0;

        int count1 = 0;
        int count2 =0;

        int major1 = Integer.MIN_VALUE;
        int major2 = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();


        for(int i=0;i<nums.length;i++){
            if(count1 == 0 && nums[i] != ele2){
                ele1 = nums[i];
                count1=1;
            }else if(count2 == 0 && nums[i] != ele1){
                ele2 = nums[i];
                count2 =1;
            }else if(nums[i] == ele1){
                count1++;
            }else if(nums[i] == ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num : nums){
            if(num == ele1){
                count1++;
            }else if(num == ele2){
                count2++;
            }
        }

        if(count1 > nums.length/3){
            list.add(ele1);
        }

        if(count2 > nums.length/3){
            list.add(ele2);
        }
        return list;
    }
}