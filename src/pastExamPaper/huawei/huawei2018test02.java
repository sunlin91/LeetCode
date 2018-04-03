package pastExamPaper.huawei;

import java.util.Scanner;

/**
 * 85%
 */
public class huawei2018test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        if ("0000:0000:0000:0000:0000:0000:0000:0000".equals(str)) {
            System.out.println("Unspecified");
            return;
        }
        if ("0000:0000:0000:0000:0000:0000:0000:0001".equals(str)) {
            System.out.println("Loopback");
            return;
        }
        String[] s_list = str.split(":");
        if (s_list.length != 8) {
            System.out.println("Error");
            return;
        }
        char[][] ipv6_list = new char[8][4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                ipv6_list[i][j] = s_list[i].charAt(j);
            }
        }

        int len_zero = 0;
        boolean index = false;
        for (int i = 0; i < 8; i++) {
            if (ipv6_list[i].length != 4) {
                System.out.println("Error");
                return;
            }
            for (int j = 0; j < 4; j++) {
                if (!helper(ipv6_list[i][j])){
                    System.out.println("Error");
                    return;
                }
                if (ipv6_list[i][j] == '0')
                    len_zero += 4;
            }
            if (ipv6_list[7][3] == '1')
                index = true;
            if (len_zero == 128) {
                System.out.println("Unspecified");//
                return;
            }
            if (len_zero == 124 && index) {
                System.out.println("Loopback");//
                return;
            }
            if (ipv6_list[0][0] == 'F' && ipv6_list[0][1] == 'E' && (ipv6_list[0][2] == '8' || ipv6_list[0][2] == 'A' || ipv6_list[0][2] == '9' || ipv6_list[0][2] == 'B')) {
                System.out.println("LinkLocal");
                return;
            }
            if (ipv6_list[0][0] == 'F' && ipv6_list[0][1] == 'E' && (ipv6_list[0][2] == 'C' || ipv6_list[0][2] == 'D' || ipv6_list[0][2] == 'E' || ipv6_list[0][2] == 'F')) {
                System.out.println("SiteLocal");
                return;
            }
            if (ipv6_list[0][0] == 'F' && ipv6_list[0][1] == 'F') {
                System.out.println("Multicast");
                return;
            }
            System.out.println("GlobalUnicast");//

        }
    }
    static boolean helper(char a){
        return (a>='0'&&a<='9')||(a>='A'&&a<='F');
    }
}
