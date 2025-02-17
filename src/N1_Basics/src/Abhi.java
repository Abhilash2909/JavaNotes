package N1_Basics.src;
import java.util.ArrayList;

public class Abhi {

//    Recursion--->
//    first identify the below things
//    - Bigger problem
//    - Smaller problem
//    - Self work
//    - Base condition

//    Then code accordingly...
//    base case
//    recursive work
//    self work

    public static void main(String[] args) {{}
        String s = "abhi";
        int num = 111010111;
        boolean flag = false;
        int ans = reverse(num, 0);
        if(num == ans) {
            flag = true;
        }
        System.out.println(flag);
    }

    //  is number palindrome or not --> O(n)
    private static int reverse(int num, int rev) {
        if (num == 0) {
            return rev;
        }
        return reverse(num/10, rev*10 + num%10);
    }

    //  is string palindrome or not
    private static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
        return isPalindrome(s, i+1, j-1);
    }

    //  Reverse a string --> O(n)
    private static String reverse(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String ans = reverse(s.substring(1));
        return ans + s.charAt(0);
    }

    //     Remove all character occurrences2  --> O(n*2)
    private static String removeOccurences2(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String ans = removeOccurences2(s.substring(1));
        char currChar = s.charAt(0);
        if (currChar != 'a') {
            return currChar + ans;
        } else {
            return ans;
        }
    }

    //     Remove all character occurrences --> O(n*2)
    private static String removeOccurences(String s, char ch, int idx) {
//        if (idx == s.length()) {
//            return "";
//        }
//        String str = "";
//        if(s.charAt(idx) != ch) {
//            str = str + s.charAt(idx);
//        }
//        String ans =  str + removeOccurences(s, 'a', idx + 1);;
//        return ans;

        if (idx == s.length()) return "";
        String ans = removeOccurences(s, 'a', idx + 1);
        if (s.charAt(idx) != ch) {
            return s.charAt(idx) + ans;
        } else {
            return ans;
        }
    }

    //    Return index if x exists in the array
    private static int findIdx(int[] arr, int ele, int idx) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == ele) {
            return idx;
        }
        return findIdx(arr, ele, idx + 1);
    }

    //    Print whether x exists in the array or not
    private static boolean elementExists(int[] arr, int ele, int idx) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == ele) {
            return true;
        }
        return elementExists(arr, ele, idx + 1);
    }

    //    Sum of all elements in an array
    private static int sumOfElements(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        return arr[idx] + sumOfElements(arr, idx + 1);
    }

    //    Print the max value of array
    private static int maxValue(int[] arr, int idx, int max) {
        if (idx == arr.length) {
            return max;
        }
        return maxValue(arr, idx + 1, Math.max(max, arr[idx]));
    }

    //    Print all the values in an array recursively.
    private static void printRecursively(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            System.out.print(arr[idx] + " ");
            return;
        }
        System.out.print(arr[idx] + " ");
        printRecursively(arr, idx + 1);
    }

    //    Sorted or not
    private static boolean isSorted(int[] ar, int idx1, int idx2) {
        if (idx1 >= ar.length || idx2 >= ar.length) {
            return true;
        }

        if (ar[idx1] >= ar[idx2]) {
            return false;
        }

        return isSorted(ar, idx1 + 1, idx2 + 1);
    }

    //    linear search(print all the indices of the target)
    private static void printAllIndices(int[] ar, int target, int idx) {
        if (idx == ar.length) {
            return;
        }

        if (ar[idx] == target) {
            System.out.print(idx + " ");
        }

        printAllIndices(ar, target, idx + 1);
    }

    //    linear search(store all the indices of the target and return it)
    private static ArrayList<Integer> findAllIndices(int[] ar, int target, int idx) {
        if (idx == ar.length) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (ar[idx] == target) {
            ans.add(idx);
        }
        ArrayList<Integer> list = findAllIndices(ar, target, idx + 1);
        ans.addAll(list);
        return ans;
    }

    //    linear search (return last idx of the target)
    private static int findLastIndex(int[] ar, int target, int idx) {
        if (idx == 0) {
            return -1;
        }

        if (ar[idx] == target) {
            return idx;
        }

        return findLastIndex(ar, target, idx - 1);
    }

    //    linear search (return first idx of the target)
    private static int findFirstIndex(int[] ar, int target, int idx) {
        if (idx == ar.length - 1) {
            return -1;
        }

        if (ar[idx] == target) {
            return idx;
        }

        return findFirstIndex(ar, target, idx + 1);
    }

    //    linear search (return true or false)
    private static boolean search1(int[] ar, int target, int idx) {
        if (idx == ar.length - 1) {
            return false;
        }

        if (ar[idx] == target) {
            return true;
        }

        return search1(ar, target, idx + 1);
    }

    //    print the sum of elements of the array
    private static int sumOfArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        int sum = sumOfArray(arr, idx + 1);

        return sum + arr[idx];
    }

    //    print the max element of the array
    private static int maxElement(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int smallAns = maxElement(arr, idx + 1);
        return Math.max(arr[idx], smallAns);
    }

    //    Print the elements of the array
    private static void printArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        printArray(arr, idx + 1);
    }

    //    GCD of a, b
//    --recursive solution
//    * * Euclid's Algo --> gcd(a, b) = gcd(b, a % b) * *
    private static int gcd1(int a, int b) { // T.C = O(min(a, b))
        if (b == 0) {
            return a;
        }

        return gcd1(b, a % b);
    }

    //    --iterative solution
    private static int gcd2(int a, int b) {  // T.C = O(min(a, b))
//        for(int i=Math.min(a, b); i>=2; i--)
//            if(a % i == 0 && b % i == 0)
//                return i;
//        return 1;

        while (a % b != 0) {  // T.C = O(log N)
            int rem = a % b;
            a = b;
            b = rem;
        }

        return b;
    }

    //  sum of natural numbers with alternative signs
    private static int altSeriesSum(int n) {
        if (n == 0) {
            return 0;
        }

        int t = altSeriesSum(n - 1);

        if (n % 2 == 0) {
            return t - n;
        }

        return t + n;
    }

    //  Print k multiples of n
    private static void printMultiples(int n, int k) {
        if (k == 0) return;
        printMultiples(n, k - 1);
        System.out.print(n * k + " ");
    }

    //  power of a, b--->
    private static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int t = pow(a, b / 2);

        if (b % 2 == 0) {
            return t * t;
        }

        return a * t * t;
    }

    //    sumOfDigits--->
    private static int sod(int n) {
        if (n == 0) {
            return 0;
        }

        return sod(n / 10) + (n % 10);
    }

    //    factorial--->
    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return factorial(n - 1) * n;
    }

    //    fibonacci series--->
    public static int fibo(int a) {
        if (a <= 2) {
            return 1;
        }

        return fibo(a - 1) + fibo(a - 2);
    }


    //Calculating Time complexities--->
    private static void complexities(int n) {
        int val = 0;

        for (int i = 1; i <= n; i *= 2) {
            val++;                         //  TC --> O(logN)
        }

        for (int i = 1; i <= n; i += i) {
            val++;                        //  TC --> O(logN)
        }

        for (int i = 1; i <= n; i *= 2) {
            for (int j = 1; j <= i; j++)
                val++;                    //  TC --> O(N)
        }

        for (int i = 1; i <= n; i *= 2) {
            for (int j = n; j > 0; j--)
                val++;                    //  TC --> O(NlogN)
        }

        for (int i = n; i > 0; i /= 2) {
            for (int j = 0; j < i; j++)
                val++;                    //  TC --> O(N)
        }

        for (int i = 2; i <= n; i *= i) {
            val++;                        //  TC --> O(log(logN))
        }

        System.out.println(val);
    }

    //Printing Patterns--->
    static void Pattern1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    static void Pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    static void Pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    static void Pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void Pattern5(int n) {
        for (int i = 1; i < 2 * n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
        }
    }

    //
//  Missing number--->
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            if (Math.abs(arr[i]) - 1 == n) {
//                continue;
//            }
//            int ind = Math.abs(arr[i]) - 1;
//            arr[ind] *= -1;
//        }
//        int ans;
//        for(int i = 0; i < n; i++) {
//            if (arr[i] > 0){
//                ans = i + 1;
//                System.out.println(ans);
//                return;
//            }
//        }
//        System.out.println(n+1);
//    }
//
//  Tables--->
    static void Table(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + "*" + i + "=" + number * i);
        }
    }

    //
//  leap year--->
    static void leapYear(int year) {
        if (year % 4 == 0 || (year % 100 != 0 && year % 400 == 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
//
//  HCF and LCM--->
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int x = a;
//        int y = b;
//        int r = 0;
//        while(b != 0){
//            r = a % b;
//            a = b;
//            b = r;
//        }
//        System.out.println(a + " " + (x*y)/a);
//    }

//    String s = sc.next();   reads the input string upto the space

//    String s = sc.nextLine();   reads the input string with space

//    // Declare String without using new operator--->
//    String s = "GeeksforGeeks";
//
//    // Prints the String.
//    System.out.println("String s = " + s);
//
//    // Declare String using new operator--->
//    String s1 = ("GeeksforGeeks");
//
//    // Prints the String.
//    System.out.println("String s1 = " + s1);
}