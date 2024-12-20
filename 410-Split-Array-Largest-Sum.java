class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for(int num:nums){
            low = Math.max(low,num);
            high += num;
        }
        while(low<=high){
            int mid = low + (high - low)/2;
            int counts = noOfSubArray(nums,mid);
            if(counts<= k) high = mid - 1;
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private static int noOfSubArray(int[] nums, int sumMax){
        int count = 1, sum = 0;
        for(int x : nums){
            if(x+sum <= sumMax){
                sum += x;
            }else{
                count++;
                sum = x;
            }
        }
        return count;
    }
}