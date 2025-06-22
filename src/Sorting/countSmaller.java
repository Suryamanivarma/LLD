package Sorting;

public class countSmaller {
    static  int[] indicies;
    static int[] count;
    public static void main(String[] args) {
        int[] arr={5,2,6,1};
        int n=arr.length;
        indicies=new int[n];//created array to track indicies and default value are o
        count=new int[n];
        for(int i=0;i<n;i++){
            indicies[i]=i;//marking indicies in array
        }

        mergeSort(arr,0,n-1);

    }

    private static int[] mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            return new int[]{indicies[low]};
        }

        int mid = (low + high) / 2;
        int[] left = mergeSort(nums, low, mid);
        int[] right = mergeSort(nums, mid + 1, high);

        return merge(nums, left, right);
    }

    private static int[] merge(int[] nums, int[] left, int[] right) {
        int n = left.length, m = right.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;
        int rightCounter = 0;

        while (i < n && j < m) {
            if (nums[right[j]] < nums[left[i]]) {
                merged[k++] = right[j++];
                rightCounter++;
            } else {
                count[left[i]] += rightCounter;
                merged[k++] = left[i++];
            }
        }

        while (i < n) {
            count[left[i]] += rightCounter;
            merged[k++] = left[i++];
        }

        while (j < m) {
            merged[k++] = right[j++];
        }

        return merged;
    }
}
