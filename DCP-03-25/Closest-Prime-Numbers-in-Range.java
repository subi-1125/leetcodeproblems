class Solution {
    public List<Integer> sieve(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primeList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primeList = sieve(left,right);
        
        if (primeList.size() <= 1) return new int[]{-1, -1};
        
        int minDiff = Integer.MAX_VALUE;
        int prime1 = -1, prime2 = -1;
        
        for (int i = 1; i < primeList.size(); i++) {
            int diff = primeList.get(i) - primeList.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                prime1 = primeList.get(i - 1);
                prime2 = primeList.get(i);
            }
        }
        return new int[]{prime1, prime2};
    }
}