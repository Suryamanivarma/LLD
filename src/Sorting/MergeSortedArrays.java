package Sorting;

import java.util.Arrays;

//Leetcode 88: Merge Sorted Array
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        mergeArrays(nums1,m,nums2,n);
//        for(int a : nums1){
//            System.out.print(a+" ");
//        }
        System.out.println();
        mergeArraysOptimal(nums1,m,nums2,n);

        for(int a : nums1){
            System.out.print(a+" ");
        }

    }

    /*
    Brute force: adding elements at the end and sorting it finally
    TC: O(n+m)*log(n+m);
    SC:O(N)
     */
    public static void mergeArrays(int[] arr1,int m,int[] arr2,int n){
        for(int i=0;i<n;i++){
            arr1[i+m]=arr2[i];
        }

        Arrays.sort(arr1);
    }

    /*
        we are iterting from last and comparing the elements and placing them at right
        position
        TC:O(M+N)
        SC:O(1)
     */
    public static void mergeArraysOptimal(int[] arr1,int m,int[] arr2,int n){
       int i=m-1;
       int j=n-1;
       int k=m+n-1;

       while(i>=0 && j>=0){
           if(arr1[i]>arr2[j]){
               arr1[k]=arr1[i];
               k--;
               i--;
           }else{
               arr1[k]=arr2[j];
               k--;j--;
           }
       }

       while(j>=0){
           arr1[k]=arr2[j];
           j--;
           k--;
       }

    }


}
