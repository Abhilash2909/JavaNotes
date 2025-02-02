import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DP27_EggDropping {

    static int[][] t = new int[11][51];

    public static int solveRec(int e, int f) {
        //Base Case ::
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;

        int min = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int temp = 1 + Math.max(solveRec(e-1, k-1), solveRec(e-1, f-k));
            min = Math.min(min, temp);
        }

        return min;
    }

    public static int solveMemo(int e, int f) {
        //Base Case ::
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(t[e][f] != -1) {
            return t[e][f];
        }

        int min = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int temp = 1 + Math.max(solveMemo(e-1, k-1), solveMemo(e, f-k));
            min = Math.min(min, temp);
        }

        return t[e][f] = min;
    }

    public static int memOptimization(int e, int f) {
        //Base Case ::
        if(f == 0 || f == 1) {
            return f;
        }
        if(e == 1) {
            return f;
        }
        if(t[e][f] != -1) {
            return t[e][f];
        }

        int min = Integer.MAX_VALUE;
        int low, high;
        for(int k=1; k<=f; k++){
            if(t[e-1][k-1] != -1) {
                low = t[e-1][k-1];
            } else {
                low = memOptimization(e - 1, f - 1);
                t[e-1][k-1] = low;
            }
            if(t[e][f-k] != -1) {
                high = t[e][f-k];
            } else {
                high = memOptimization(e, f - k);
                t[e][f-k] = high;
            }
            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }

        return t[e][f] = min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eggs = sc.nextInt();
        int floors = sc.nextInt();

        for(int[] a : t) {
            Arrays.fill(a,-1);
        }

        int res;

        // Recursive
//        res = solveRec(eggs, floors);

        // Memoized
//        res = solveMemo(eggs, floors);

        // Memoization Optimization
        res = memOptimization(eggs, floors);

        System.out.println(res);
    }
}
