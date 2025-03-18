class Solution {
    public int longestNiceSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1;
        for(int i = 0;i < nums.length; i++)
        {
            int count = 1;
            long a = nums[i];
            for(int j = i + 1; j < nums.length; j++)
            {
                long b = nums[j];
                long c = nums[j-1];
                if(((a & b) == 0)&&(b & c) == 0)
                {
                    boolean flag = true;
                    if(count >= 2)
                    {
                        for(int x = i + 1;x < j;x++)
                        {
                            if((nums[x] & nums[j]) != 0)
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(!flag)break;
                    count++;
                }
                else break;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}