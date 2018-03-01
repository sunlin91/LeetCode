package huawei;

import java.util.Scanner;

/**
 * Created by SUN on 2018.3.1.
 */
public class test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String left = line.split("-")[0];
            String right = line.split("-")[1];
            String l=left,r=right;
            if (left.equals("joker JOKER") || right.equals("joker JOKER")) {
                System.out.println("joker JOKER");
                continue;
            }

            left = left.replace("10", "a");
            right = right.replace("10", "a");
            left = left.replace("J", "b");
            right = right.replace("J", "b");
            left = left.replace("Q", "c");
            right = right.replace("Q", "c");
            left = left.replace("K", "d");
            right = right.replace("K", "d");
            left = left.replace("A", "e");
            right = right.replace("A", "e");
            left = left.replace("2", "f");
            right = right.replace("2", "f");

            if (left.length() != right.length()) {
                if (left.length() == 7)
                    System.out.println(l);
                else if (right.length() == 7)
                    System.out.println(r);
                else
                    System.out.println("ERROR");
                continue;
            }
            System.out.println(left.charAt(0)>right.charAt(0) ? l : r);
        }
    }

}
