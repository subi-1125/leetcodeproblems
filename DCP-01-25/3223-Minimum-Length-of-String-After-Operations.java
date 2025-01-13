class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
            int res = 0; 
            for (char ch : s.toCharArray()){
                freq.put(ch,freq.getOrDefault(ch, 0) + 1);}

                for (int count : freq.values()){
                    if (count > 2){
                    if (count % 2 == 0) {
                        res += 2;}
                        else{
                            res += 1;}
                        }
                        else{
                        res += count;
                    }
                }
                return res;
    }
}