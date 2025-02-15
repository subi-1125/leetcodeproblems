class Solution {
    static Boolean[] cache = new Boolean[1001];  
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int squareNum = i * i;
            if (cache[i] == null) { 
                cache[i] = isValid(i, squareNum, 0); 
            }
            if (cache[i]) {
                sum += squareNum;
            }
        }
        return sum;
    }


    public boolean isValid(int num, int curNum ,int sum){
        int totalDigits = curNum == 0 ? 0 :(int) Math.log10(curNum) + 1;
        if(totalDigits == 1){
            return (num == (sum + curNum)) ? true : false;
        }else if(totalDigits == 0){
            return num == sum;
        }
        for(int i = 1; i <= totalDigits; i++){
            int x = power(10,totalDigits - i);
            if(isValid(num,curNum % x,sum + (curNum / x))){
                return true;
            }
        }
        return false;
    }

    public int power(int base, int expo) {
        int res = 1;  
        while (expo > 0) {  
            if ((expo & 1) == 1) {  
                res *= base;
            }
            base *= base;  
            expo >>= 1;  
        }
        return res;
    }
}