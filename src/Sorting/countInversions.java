package Sorting;

public class countInversions {
    public static void main(String[] args) {
        int[] arr={2, 4, 1, 3, 5};
        int ans=countInversions(arr);
        System.out.println(ans);

    }

    /*
        TC:O(N^2)
        SC:O(1)
     */
    public static int countInversions(int[] A) {
        int n=A.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A[i]>A[j]){
                    count++;
                }
            }
        }

        return count;
    }
}
