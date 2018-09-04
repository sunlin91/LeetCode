package pastExamPaper.xiecheng;

import java.util.*;

public class test02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int timeA = in.nextInt();
        Order[] dds = new Order[N];
        for (int i = 0; i < N; i++) {
            int in1 = in.nextInt();
            int in2 = in.nextInt();
            int in3 = in.nextInt();
            dds[i] = new Order(in1, in2, in3);
        }
        Arrays.sort(dds, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.in - o2.in;
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        int l = 0;
        int r = N - 1;
        helper(dds, l, r, result, timeA);

        if (result.size() == 0) {
            System.out.println("null");
            return;
        }
        Collections.sort(result);
        for (int rr : result) {
            System.out.println(rr);
        }
    }

    private static void helper(Order[] dds, int l, int r, ArrayList result, int timeA) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (timeA >= dds[mid].in && timeA <= dds[mid].out) {
                result.add(dds[mid].no);

            }
            helper(dds, l, mid - 1, result, timeA);
            helper(dds, mid + 1, r, result, timeA);
        }
    }
}


class Order {
    int no;
    int in;
    int out;

    public Order(int no, int in, int out) {
        this.no = no;
        this.in = in;
        this.out = out;
    }


}
