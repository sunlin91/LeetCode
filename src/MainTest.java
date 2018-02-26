public class MainTest {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 1, 1,1}, {2,2,2,2}, {3,3,3,3},{4,4,4,4}};
        Q048_RotateImage q = new Q048_RotateImage();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        q.rotate(a);
        System.out.println("==========");
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
