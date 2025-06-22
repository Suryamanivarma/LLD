package Sorting;

public class countInversionsOptimal {
    public static int count=0;
    public static void main(String[] args) {
        int[] arr={2, 4, 1, 3, 5};
        mergeSort(arr,0,arr.length-1);
        System.out.println(count);
    }

    public static int[] mergeSort(int[] arr,int low,int high){
        if(low==high){
            return new int[]{arr[low]};
        }

        int mid=(low+high)/2;
        int[] left=mergeSort(arr,low,mid);
        int[] right=mergeSort(arr,mid+1,high);

        return merge(left,right);
    }

    public static int[] merge(int[] A,int[] B){
        int n=A.length;
        int m=B.length;
        int[] ans=new int[n+m];

        int p1=0,p2=0,p3=0;
        while(p1<n && p2<m){
            if(A[p1]<=B[p2]) {
                ans[p3] = A[p1];
                p1++;
                p3++;
            }else{
                ans[p3]=B[p2];
                p2++;
                p3++;
                count=count+n-p1;// [n-1,p1]=> n-1-p1+1
            }
        }
        while(p1<n){
            ans[p3] = A[p1];
            p1++;
            p3++;
        }
        while(p2<m){
            ans[p3]=B[p2];
            p2++;
            p3++;
        }

        return ans;
    }


}
