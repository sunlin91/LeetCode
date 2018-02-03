/**
 * Created by SUN on 2017.11.20.
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class Q004_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;

        int pos=0,pos1,pos2,r1=0,r2=0,i=0,j=0;
        double result=0.0;
        if((m+n)%2==0){
            pos1=(m+n)/2-1;
            pos2=(m+n)/2;
            while (i<m&&j<n){
                if(nums1[i]<nums2[j]){
                    if(pos==pos1)
                        r1=nums1[i];
                    if(pos==pos2) {
                        r2 = nums1[i];
                        return (r1+r2)/2.0;
                    }
                    i++;
                }else {
                    if(pos==pos1)
                        r1=nums2[j];
                    if(pos==pos2) {
                        r2 = nums2[j];
                        return (r1+r2)/2.0;
                    }
                    j++;
                }
                pos++;
            }
            while (i<m){
                if(pos==pos1)
                    r1=nums1[i];
                if(pos==pos2) {
                    r2 = nums1[i];
                    return (r1+r2)/2.0;
                }
                i++;
                pos++;
            }
            while (j<n){
                if(pos==pos1)
                    r1=nums2[j];
                if(pos==pos2) {
                    r2 = nums2[j];
                    return (r1+r2)/2.0;
                }
                j++;
                pos++;
            }
            result=(r1+r2)/2.0;
        }else {
            pos1=(m+n)/2;
            while (i<m&&j<n){
                if(nums1[i]<nums2[j]){
                    if(pos==pos1) {
                        r1 = nums1[i];
                        return r1;
                    }
                    i++;
                }else {
                    if(pos==pos1) {
                        r1 = nums2[j];
                        return r1;
                    }
                    j++;
                }
                pos++;
            }
            while (i<m){
                if(pos==pos1) {
                    r1 = nums1[i];
                    return r1;
                }
                i++;
                pos++;
            }
            while (j<n){
                if(pos==pos1) {
                    r2 = nums2[j];
                    return r2;
                }
                j++;
                pos++;
            }
            result=r1;
        }
        return result;
    }
}
