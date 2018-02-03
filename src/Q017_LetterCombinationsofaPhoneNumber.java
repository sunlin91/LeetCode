import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.12.
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class Q017_LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            if((digits.charAt(i))>'9'||(digits.charAt(i))<'0')
                return null;
            if(digits.charAt(i)=='1')
                continue;
            if(result.size()==0){
                for(char c:numToLetters(digits.charAt(i)+"")){
                    result.add(c+"");
                }
            }else {
                int len=result.size();
                for(int j=0;j<len;j++){
                    String str=result.remove(0);
                    for(char c:numToLetters(digits.charAt(i)+"")){
                        result.add(str+c);
                    }
                }
            }
        }
        return result;
    }

    char[] numToLetters(String num){
        switch (num){
            case "0":
                return new char[]{' '};
            case "1":
                return null;
            case "2":
                return new char[]{'a','b','c'};
            case "3":
                return new char[]{'d','e','f'};
            case "4":
                return new char[]{'g','h','i'};
            case "5":
                return new char[]{'j','k','l'};
            case "6":
                return new char[]{'m','n','o'};
            case "7":
                return new char[]{'p','q','r','s'};
            case "8":
                return new char[]{'t','u','v'};
            case "9":
                return new char[]{'w','x','y','z'};
        }
        return null;
    }
}
