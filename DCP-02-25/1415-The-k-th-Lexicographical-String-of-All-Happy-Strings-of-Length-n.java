class Solution {
    private int count = 0;
    private String result = "";
    
    public String getHappyString(int n, int k) {
        backtrack(n, new StringBuilder(), k);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, int k) {
        if (sb.length() == n) {
            count++;
            if (count == k) {
                result = sb.toString();
            }
            return;
        }
        
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                backtrack(n, sb, k);
                sb.deleteCharAt(sb.length() - 1);
                if (!result.isEmpty()) return;//prevents unnecessary recursive calls once the desired k-th happy string has been found
            }
        }
    }
}