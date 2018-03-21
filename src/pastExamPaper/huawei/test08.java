package pastExamPaper.huawei;

import java.util.*;

/**
 * Created by SUN on 2018.3.1.
 * <p>
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；
 * (文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * (如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 * <p>
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * 文件路径为windows格式
 * <p>
 * 如：E:\V1R2\product\fpgadrive.c 1325
 * <p>
 * <p>
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 * <p>
 * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 * <p>
 * 如果超过8条记录，则只输出前8条记录.
 * <p>
 * 如果文件名的长度超过16个字符，则只输出后16个字符
 * <p>
 * 输入例子1:
 * E:\V1R2\product\fpgadrive.c 1325
 * <p>
 * 输出例子1:
 * fpgadrive.c 1325 1
 */
public class test08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int index = str.lastIndexOf("\\");
            if (index > 0)
                str = str.substring(index + 1);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 8 && map.keySet().size() > 0; i++) {
            int maxTimes=0;String maxKey="";
            for (String k : map.keySet()) {
                if (map.get(k)>maxTimes){
                    maxKey=k;
                    maxTimes=map.get(k);
                }
            }
            map.remove(maxKey);
            String fileName = maxKey.split(" ")[0];
            String errorLine = maxKey.split(" ")[1];
            if (fileName.length() > 16)
                fileName = fileName.substring(fileName.length() - 16);
            result.add(fileName+" "+errorLine+" "+maxTimes);
        }
        for (int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}