import java.util.Stack;

/**
 * Created by SUN on 2017.12.13.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}"
 * are all valid but "(]" and "([)]" are not.
 */
public class Q020_ValidParentheses {
    public boolean isValid(String s) {
        if(s==null)
            return true;
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':{
                    stack.push(s.charAt(i));break;
                }
                case '{':{
                    stack.push(s.charAt(i));break;
                }
                case '[':{
                    stack.push(s.charAt(i));break;
                }
                case ')':{
                    if(!stack.isEmpty()&&stack.pop().equals('(')){
                        break;
                    }else return false;
                }
                case '}':{
                    if(!stack.isEmpty()&&stack.pop().equals('{')){
                        break;
                    }else return false;
                }
                case ']':{
                    if(!stack.isEmpty()&&stack.pop().equals('[')){
                        break;
                    }else return false;
                }
                default:return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
