package pastExamPaper.toutiao;

import java.util.*;


/**
 * 3
 * 1,10;32,45
 * 78,94;5,16
 * 80,100;200,220;16,32
 *
 * 输出
 * 1,45;78,100;200,220
 * */
public class qiuzhao02 {
    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String print(){
            return start+","+end;
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {

            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Interval> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = sc.nextLine().trim();
            String[] intervals = str.split(";");
            for(String s:intervals){
                int start = Integer.parseInt(s.split(",")[0]);
                int end = Integer.parseInt(s.split(",")[1]);
                list.add(new Interval(start,end));
            }
        }
        List<Interval> res = merge(list);
        for(int i=0;i<res.size();i++){
            if (i==res.size()-1)
                System.out.println(res.get(i).print());
            else
                System.out.print(res.get(i).print()+";");
        }
    }
}
