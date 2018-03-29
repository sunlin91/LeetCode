import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }
    public static int sqrt(int x) {
        int low = 0;
        int high = x;
        while(low<=high){
            long mid = (long)(low + high)/2;
            if(mid*mid < x)
                low = (int)mid + 1;
            else if(mid*mid > x)
                high = (int)mid - 1;
            else
                return (int)mid;
        }
        return high;
    }

    void merge(int A[],int m, int B[], int n ){
        int k = n + m - 1;
        int i = m - 1, j = n - 1;
        while(i>=0 && j>=0){
            if(A[i] > B[j]) A[k--] = B[i--];
            else A[k--] = A[j--];
        }
        while(j>=0) A[k--] = B[j--];
    }
}
