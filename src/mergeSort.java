public class mergeSort {
    public static void merge(int[] ar, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[]a = new int[n1];
        int[]b = new int[n2];

        for(int i=0; i<n1; ++i) {
            a[i] = ar[l+i];
        }
        for(int j=0; j<n2; ++j) {
            b[j] = ar[m + 1 + j];
        }

        int k = l;
        int i = 0, j = 0;

        while(i < n1 && j < n2) {
            if(a[i] <= b[j]) {
                ar[k] = a[i];
                i++;
            } else {
                ar[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            ar[k] = a[i];
            i++;
            k++;
        }
        while(j < n2) {
            ar[k] = b[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] ar, int l, int r) {
        if(l < r) {
            int m = (l + r) / 2;
            mergeSort(ar, l, m);
            mergeSort(ar, m+1, r);
            merge(ar, l, m, r);
        }
    }
    public static void main(String[] args) {
        int[] ar = {3, 1, 4, 2, 5};
        mergeSort(ar, 0, ar.length-1);
        for(int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

//    public static void main(String[] args) {
//        int[] arr = {5, 2, 8, 3, 1, 9, 4, 7, 6};
//        mergeSort(arr);
//        System.out.println("Sorted array:");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void mergeSort(int[] arr) {
//        if (arr.length <= 1) {
//            return;
//        }
//
//        int mid = arr.length / 2;
//
//        int[] left = new int[mid];
//        int[] right = new int[arr.length - mid];
//
//        for (int i = 0; i < mid; i++) {
//            left[i] = arr[i];
//        }
//
//        for (int i = mid; i < arr.length; i++) {
//            right[i - mid] = arr[i];
//        }
//
//        mergeSort(left);
//        mergeSort(right);
//
//        merge(arr, left, right);
//    }
//
//    public static void merge(int[] arr, int[] left, int[] right) {
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i < left.length && j < right.length) {
//            if (left[i] <= right[j]) {
//                arr[k] = left[i];
//                i++;
//            } else {
//                arr[k] = right[j];
//                j++;
//            }
//            k++;
//        }
//
//        while (i < left.length) {
//            arr[k] = left[i];
//            i++;
//            k++;
//        }
//
//        while (j < right.length) {
//            arr[k] = right[j];
//            j++;
//            k++;
//        }
//    }