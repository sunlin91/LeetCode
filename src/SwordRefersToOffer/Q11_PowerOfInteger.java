package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Q11_PowerOfInteger {
    public double Power(double base, int exponent) {
        if(exponent==0)
            return 1.0;
        if(exponent<0){
            exponent=-exponent;
            base=1/base;
        }
        double r = 1.0;
        while(exponent>0){
            if((exponent&1)==1)
                r*=base;
            base*=base;
            exponent>>=1;
        }
        return r;
    }
}
