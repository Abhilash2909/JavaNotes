import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Abhi {

//    Recursion--->
//    - Bigger problem
//    - Smaller problem
//    - Self work
//    - Base condition

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printRecursively(arr, 0);
    }
//    Print all the values in an array recursively.
    private static void printRecursively(int[] arr, int idx) {
        if(idx == arr.length-1) {
            System.out.print(arr[idx] + " ");
            return;
        }
        System.out.print(arr[idx] + " ");
        printRecursively(arr, idx+1);
    }

    //    Sorted or not
//    private static boolean isSorted(int[] ar, int idx1, int idx2) {
//        if(idx1 >= ar.length || idx2 >= ar.length) {
//            return true;
//        }
//
//        if(ar[idx1] >= ar[idx2]) {
//            return false;
//        }
//
//        return isSorted(ar, idx1 + 1, idx2 + 1);
//    }

    //    linear search (return last idx of the target)
    private static int findLastIndex(int[] ar, int target, int idx) {
        if(idx == 0) {
            return -1;
        }

        if(ar[idx] == target) {
            return idx;
        }

        return findLastIndex(ar, target, idx-1);
    }

//    linear search(find all the indices of the target)
    private static ArrayList<Integer> findAllIndices(int[] ar, int target, int idx) {
        if(idx == ar.length) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> li = new ArrayList<>();

        if(ar[idx] == target) {
            li.add(idx);
        }

        ArrayList<Integer> list =  findAllIndices(ar, target, idx + 1);

        li.addAll(list);

        return li;
    }

//    linear search (return first idx of the target)
    private static int findFirstIndex(int[] ar, int target, int idx) {
        if(idx == ar.length-1) {
            return -1;
        }

        if(ar[idx] == target) {
            return idx;
        }

        return findFirstIndex(ar, target, idx+1);
    }

//    linear search (return true or false)
    private static boolean search1(int[] ar, int target, int idx) {
        if(idx == ar.length-1) {
            return false;
        }

        if(ar[idx] == target) {
            return true;
        }

        return search1(ar, target, idx+1);
    }

//    print the sum of elements of the array
    private static int sumOfArray(int[] arr, int idx) {
        if(idx == arr.length - 1) {
            return arr[idx];
        }

        int sum = sumOfArray(arr, idx + 1);

        return sum + arr[idx];
    }

//    print the max element of the array
    private static int maxElement(int[] arr, int idx) {
        if(idx == arr.length - 1) {
            return arr[idx];
        }
        int smallAns =  maxElement(arr, idx + 1);
        return Math.max(arr[idx], smallAns);
    }

//    Print the elements of the array
    private static void printArray(int[] arr, int idx) {
        if(idx == arr.length) {
            return;
        }
        System.out.print(arr[idx] + " ");
        printArray(arr, idx + 1);
    }

//    GCD of a, b
//    --recursive solution
//    * * Euclid's Algo --> gcd(a, b) = gcd(b, a % b) * *
    private static int gcd1(int a, int b) { // T.C = O(min(a, b))
        if(b == 0) {
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

        while(a % b != 0) {  // T.C = O(log N)
            int rem = a % b;
            a = b;
            b = rem;
        }

        return b;
    }

//  sum of natural numbers with alternative signs
    private static int altSeriesSum(int n) {
        if(n == 0) {
            return 0;
        }

        int t = altSeriesSum(n-1);

        if(n % 2 == 0) {
             return t - n;
        }

        return t + n;
    }

//  Print k multiples of n
    private static void printMultiples(int n, int k) {
        if(k == 0) return;
        printMultiples(n, k-1);
        System.out.print(n * k + " ");
    }

//  power of a, b--->
    private static int pow(int a, int b) {
        if(b == 0) {
            return 1;
        }

        int t = pow(a, b/2);

        if(b % 2 == 0) {
            return t * t;
        }

        return a * t * t;
    }

//    sumOfDigits--->
    private static int sod(int n) {
        if(n == 0) {
            return 0;
        }

        return sod(n/10) + (n % 10);
    }

//    factorial--->
    private static int factorial(int n) {
        if(n == 0) {
            return 1;
        }

        return factorial(n-1) * n;
    }

//    fibonacci series--->
    public static int fibo(int a) {
        if(a <= 2) {
            return 1;
        }

        return fibo(a-1) + fibo(a-2);
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
            for(int j=1; j<=i; j++)
                val++;                    //  TC --> O(N)
        }

        for (int i = 1; i <= n; i *= 2) {
            for(int j=n; j>0; j--)
                val++;                    //  TC --> O(NlogN)
        }

        for (int i = n; i>0; i /= 2) {
            for(int j=0; j<i; j++)
                val++;                    //  TC --> O(N)
        }

        for (int i = 2; i <= n; i *= i) {
            val++;                        //  TC --> O(log(logN))
        }

        System.out.println(val);
    }

//Printing Patterns--->
    static void Pattern1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    static void Pattern2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    static void Pattern3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }

    static void Pattern4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void Pattern5(int n){
        for (int i = 1; i < 2*n; i++) {
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
        static void Table(int number){
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + "*" + i +"="+ number * i);
            }
        }
//
//  leap year--->
        static void leapYear(int year){
            if(year%4 == 0 || (year%100 != 0 && year%400 == 0)){
                System.out.println("YES");
            }else{
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