class Solution {
    public int[] findErrorNums(int[] nums) {
        int  idx = 0;
        while (idx < nums.length) {
            int curr = nums[idx] - 1;
            if (nums[idx] != nums[curr]){
                nums[idx] = nums[idx] ^ nums[curr];
                nums[curr] = nums[idx] ^ nums[curr];
                nums[idx] = nums[idx] ^ nums[curr];
            }else{
                idx++;
            }
        }
        for (int i=0;i<nums.length;++i){
            if (nums[i]!= i+1){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1, -1};
    }
}