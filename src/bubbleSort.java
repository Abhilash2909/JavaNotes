public class bubbleSort {
    public static void bubbleSort(int n, int[] ar) {
        for(int i=0; i<n-1; i++) {
            Boolean flag = false;
            for(int j=0; j<n-i-1; j++) {
                if(ar[j] > ar[j+1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] ar = {3, 1, 4, 2, 5};
        bubbleSort(5, ar);
        for(int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}