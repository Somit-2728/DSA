class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length){
            return findMedianSortedArrays(arr2,arr1);
        }
    

    int n = arr1.length;
    int m = arr2.length;

    int low =0;
    int high = n;

    int half = (n+m+1)/2;

    while(low <= high){

        int cut1 = (low + high)/2;
        int cut2 = half-cut1;

        int left1;
        int right1;
        int left2;
        int right2;


        if(cut1 == 0){
            left1 = Integer.MIN_VALUE;
        }else{
            left1 = arr1[cut1-1];
        }

        if (cut1 == n) {
                right1 = Integer.MAX_VALUE;
        } else {
                right1 = arr1[cut1];
        }

        if(cut2==0){
            left2 = Integer.MIN_VALUE;
        }else{
            left2 = arr2[cut2-1];
        }

        if(cut2 == m){
            right2 = Integer.MAX_VALUE;
        }else{
            right2 = arr2[cut2];
        }

        if(left1 <= right2 && left2 <= right1){
            if((n+m)%2 == 1){
                return Math.max(left1,left2);
            }

            return (Math.max(left1,left2) + Math.min(right1, right2)) /2.0;
        }

        if(left1 > right2){
            high = cut1 -1;
        }else{
            low = cut1+1;
        }
    }
    return 0;
}
}