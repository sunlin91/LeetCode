import java.util.HashMap;

/**
 * Created by SUN on 2017.12.4.
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Q013_RomantoInteger {
    public int romanToInt(String s) {
        HashMap<Character,Integer> romanMap = new HashMap<Character,Integer>();

        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        char[] input = s.toCharArray();
        int sum = 0;

        for(int i=0; i<input.length; i++){

            int left = romanMap.get(input[i]);
            int right = 0;

            if ((i+1) < input.length){
                right = romanMap.get(input[i+1]);
            }

            if(left >= right){
                sum = sum + left;
            }else{
                sum = sum - left;
            }
        }

        return sum;
    }
}
