
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

    }
    //希尔排序
    public static void shellSort(int[] a){
        int i,j,k;
        for(int dk=a.length/2;dk>=1;dk=dk/2)
            for(i=dk;i<a.length;i++){
                if(a[i]<a[i-dk]){
                    k=a[i];
                    for(j=i-dk;j>=0&&k<a[j];j-=dk){
                        a[j+dk]=a[j];
                    }
                    a[j+dk]=k;
                }
            }
    }
}
