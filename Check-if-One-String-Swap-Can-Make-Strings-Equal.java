class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();  // Get the length of the strings

        int firstIdxDiff = -1, secondIdxDiff = -1; // Variables to store the indices where characters differ
        int diffCount = 0;  // Counter to track the number of differing characters

        int i = 0, j = 0;
        while (i < n && j < n) {  // Loop through both strings
            if (s1.charAt(i) != s2.charAt(j)) {  // If characters at the current index are different
                if (diffCount > 0) {  
                    secondIdxDiff = i;  // Store the second mismatch index
                } else {
                    firstIdxDiff = i;  // Store the first mismatch index
                }

                diffCount++;  // Increment the difference counter

                if (diffCount > 2) return false;  // More than two mismatches mean swapping won't work
            }
            i++; j++;  // Move to the next character
        }

        if (diffCount == 2) {
            // Check if swapping the two differing characters makes the strings equal
            return s1.charAt(firstIdxDiff) == s2.charAt(secondIdxDiff) &&
                   s2.charAt(firstIdxDiff) == s1.charAt(secondIdxDiff);
        } else if (diffCount == 1) {
            return false;  // If only one mismatch exists, swapping isn't possible
        }

        return true;  // If no mismatches exist, the strings are already equal
    }
}