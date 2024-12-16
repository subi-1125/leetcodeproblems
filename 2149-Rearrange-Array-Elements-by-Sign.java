class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len=nums.length;
        int pos[]=new int[len/2];
        int neg[]=new int[len/2];
        int posInd=0, negInd=0;
        for(int i=0;i<len;i++){
            if(nums[i]>=0) pos[posInd++]=nums[i];
            else neg[negInd++]=nums[i];
        }
        posInd=0;
        negInd=0;
        for(int i=0;i<len;i++){
            if(i%2==0)nums[i]=pos[posInd++];
            else nums[i]=neg[negInd++];
        }
        return nums;
    }
}
