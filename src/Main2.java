import java.util.Scanner;

/**
 * Created by SunLin on 2018.3.22
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int[] a = new int[10];
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++)
            a[chars[i]-'0']++;
        int i=1;
        while (true){
            if (!helper(a,i)){
                System.out.println(i);
                break;
            }
            i++;
        }
    }
    static boolean helper(int[] array,int number){
        int[] a = new int[array.length];
        for (int i = 0;i<array.length;i++){
            a[i]=array[i];
        }
        while (number!=0){
            int tmp = number%10;
            if (a[tmp]<=0) return false;
            else {
                number/=10;
                a[tmp]--;
            }
        }
        return true;
    }
}
