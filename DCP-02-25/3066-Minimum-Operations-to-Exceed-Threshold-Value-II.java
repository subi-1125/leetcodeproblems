class Solution {
    public int minOperations(int[] nums, int k) {
        // Use a min-heap (priority queue) to always process the smallest elements first
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int ans = 0; // Counter to track the number of operations

        // Insert all elements into the priority queue
        for(int n : nums)
            pq.offer((long) n); // Convert to long to avoid overflow

        // Process elements until all remaining elements are at least k
        while(pq.size() > 1 && pq.peek() < k) {
            // Extract the two smallest elements
            long x = pq.poll();
            long y = pq.poll();

            // Combine them using the given formula and push the new value back
            pq.offer(Math.min(x, y) * 2 + Math.max(x, y));

            // Increment the operation count
            ans++;
        }

        // Return the number of operations required
        return ans;
    }
}