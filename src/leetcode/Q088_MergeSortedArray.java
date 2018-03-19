package leetcode;

import java.util.Arrays;

/**
 * Created by SunLin on 2018.3.19
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2. The number of elements initialized in nums1 and nums2
 * are m and n respectively.
 */
public class Q088_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2==null||n==0)
            return;
        int[] copyNums1 = Arrays.copyOf(nums1,m);
        int p=0,q=0,pos=0;
        while (p<m&&q<n){
            if (copyNums1[p]<=nums2[q]){
                nums1[pos++]=copyNums1[p++];
            }else {
                nums1[pos++]=nums2[q++];
            }
        }
        while (p<m){
            nums1[pos++]=copyNums1[p++];
        }
        while (q<n){
            nums1[pos++]=nums2[q++];
        }
    }
}
