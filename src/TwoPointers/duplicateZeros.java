package TwoPointers;

public class duplicateZeros {

    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,4,5,0};

        dupicateZerosOptimal(arr);

    }

    public static void dupicateZeros(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        int idx=0,i=0;
        while(i<n && idx<n){
            if(arr[i]==0){
                idx+=2;
            }else{
                ans[idx++]=arr[i];
            }
            i++;
        }

        int index=0;
        for(int a:ans){
            arr[index++]=a;
        }

        for(int ar:arr){
            System.out.print(ar+" ");
        }

    }

    public static void dupicateZerosOptimal(int[] arr){
        int n = arr.length;
        int zeros = 0;

        // First pass: Count the number of duplicable zeros
        for (int i = 0; i + zeros < n; i++) {
            if (arr[i] == 0) {
                // Edge case: last zero fits exactly
                if (i + zeros == n - 1) {
                    arr[n - 1] = 0;
                    n--; // Don't process this zero twice
                    break;
                }
                zeros++;
            }
        }

        // Second pass: Use two pointers moving from back to front
        int i = n - 1 - zeros; // Last original element to process
        int j = n - 1;         // Last index in array

        while (i >= 0) {
            if (arr[i] == 0) {
                arr[j--] = 0; // Duplicate zero
                arr[j--] = 0;
            } else {
                arr[j--] = arr[i];
            }
            i--;
        }

    }
}
