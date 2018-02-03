/**
 * Created by SUN on 2017.11.22.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Q006_ZigZagConversion {
    public String convert(String s,int numRows){
        if(s==null||s.equals("")||s.length()==0)
            return "";
        if(numRows==1)
            return s;
        int numColumn = (s.length()/(2*numRows-2)+1)*(numRows-1);//列数
        char[][] saves = new char[numRows][numColumn];
        String result="";
        for(int i=0,pos=0;pos<s.length()&&i<s.length()/(2*numRows-2)+1;i++){
            for(int j=0;pos<s.length()&&j<numRows;j++){
                saves[j][i*(numRows-1)]=s.charAt(pos);
                pos++;
            }
            for(int k=numRows-2,l=1;pos<s.length()&&k>0;k--,l++){
                saves[k][i*(numRows-1)+l]=s.charAt(pos);
                pos++;
            }
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numColumn;j++){
                if(saves[i][j]!=0)
                    result+=saves[i][j]+"";
            }
        }
        return result;
    }
}
