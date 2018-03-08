package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Q54_isNumeric {
    public boolean isNumeric(char[] str) {
        //为true表示可以出现
        boolean eOrE = true;
        boolean point = true;
        if (str == null || str.length == 0) return false;
        for (int i = 0; i < str.length; i++) {
            if (i == 0 && (str[i] == '+' || str[i] == '-')) {
                continue;

            }
            if (str[i] >= '0' && str[i] <= '9')
                continue;
            if (str[i] == '.') {
                if (i == 0 || i == str.length - 1)
                    return false;
                if (point) {
                    point = false;
                    continue;
                } else
                    return false;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == 0 || i == str.length - 1)
                    return false;
                if (eOrE) {
                    point = false;
                    eOrE = false;
                    if (str[i+1] == '+' || str[i+1] == '-') {
                        i++;
                    }
                    continue;
                } else
                    return false;
            }else {
                return false;
            }
        }
        return true;
    }
}
