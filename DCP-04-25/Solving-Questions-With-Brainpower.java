class Solution {
    int[][] q;  // Stores the given questions array
    int n;      // Number of questions
    Long[] dp;  // Memoization array to store computed results

    public long mostPoints(int[][] questions) {
        this.q = questions;
        this.n = q.length;
        dp = new Long[n];  // Initialize memoization array

        return sol(0);  // Start solving from index 0
    }

    private long sol(int idx) {
        // Base case: If index goes out of bounds, return 0
        if (idx >= n) return 0;

        // Check if the result for this index is already computed
        if (dp[idx] != null) return dp[idx];

        // Get points and brainpower from the current question
        int points = q[idx][0];
        int brainpower = q[idx][1];

        // Option 1: Solve this question and skip 'brainpower' number of questions
        long a = points + sol(idx + 1 + brainpower);

        // Option 2: Skip this question and move to the next one
        long b = sol(idx + 1);

        // Store the maximum of both choices in dp array and return it
        return dp[idx] = Math.max(a, b);
    }
}