/**
 * Created by SUN on 2017.12.19.
 * Divide two integers without using multiplication,
 * division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class U_Q029_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int a=1,b=1;
        long ldividen=dividend,ldivisor=divisor;
        if(ldivisor==0) return Integer.MAX_VALUE;
        if(ldividen==0) return 0;
        if(ldividen<0) {a=-1;ldividen=-ldividen;}
        if(ldivisor<0) {b=-1;ldivisor=-ldivisor;}
        long result=ldivide(ldividen,ldivisor);
        if(a!=b) result=-result;
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)result;
    }
    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
