public class L_202_HappyNumber {
    public boolean isHappy(int n) {
        // Using set to prevent from infinite loop that is if we get a sum of Squares of any element is coming same that is already present in the set.
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);

            n = sumSquare(n);

            if(n == 1){
                return true;
            }       
        }
        return false;
    }
    // Simply finding sum of the squares
    public int sumSquare(int n){
        int sum = 0;
        while(n > 0){
            int digits = n%10;
            sum += Math.pow(digits,2);
            n = n/10;
        }
        return sum;
    }
}
