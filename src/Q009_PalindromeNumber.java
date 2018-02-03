/**
 * Created by SUN on 2017.11.27.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Q009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x<9)
            return true;
        int i=1,j=1,tmp=x;
        while (tmp/10>0){
            i*=10;
            tmp/=10;
        }
        while (i>=j){
            if((x/i%10)!=(x/j%10)){
                return false;
            }
            i/=10;
            j*=10;
        }
        return true;
    }
}
