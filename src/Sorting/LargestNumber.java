package Sorting;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums={10,2};
//        String ans=largestNumber(nums);
//        System.out.println(ans);

        String ans=largestNumberOptimal(nums);
        System.out.println(ans);

    }
    /*
        BruteForce : O(N^2)*k
        SC:O(N)
     */
    public static String largestNumber(int[] arr){
        int n=arr.length;
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=String.valueOf(arr[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String a=str[i];
                String b=str[j];
                if((b+a).compareTo(a+b)>0){
                    String temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for(String ar:str){
            ans.append(ar);
        }
        return ans.toString();
    }

    /*
    TC: O(NLogN*L)
    SC: O(N)
     */
    public static String largestNumberOptimal(int[] arr){
        int n=arr.length;
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            str[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
        StringBuilder ans=new StringBuilder();
        for(String ar:str){
            ans.append(ar);
        }
        return ans.toString();
    }
}
