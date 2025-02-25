class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddSeen = 0, prefSum = 0, mod = 1000000007;
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            prefSum += arr[i];
            if(prefSum % 2 == 0) {
                ans += oddSeen;
            } else {
                ans += i + 1 - oddSeen;
                oddSeen++;
            }
            ans %= mod;
        }
        return ans;
    }
}