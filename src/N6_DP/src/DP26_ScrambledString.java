import java.util.*;

public class  DP26_ScrambledString{
    static HashMap<String,Boolean> map = new HashMap<>();
    public int isScramble(final String A, final String B) {
        if(A.length() != B.length()){
            return 0;
        }
        if(A.isEmpty() && B.isEmpty()){
            return 1;
        }
        //return solveRec(A,B)==true?1:0;
        return solveMemo(A,B) ? 1 : 0;
    }

    public static boolean solveRec(String a, String b) {
        //Base Case ::
        int n=a.length();
        if(a.equals(b)) return true;
        if(a.length()<=1) return false;

        //k loop
        boolean flag=false;
        for(int k=1;k<=n-1;k++){
            boolean test1=false,test2=false;
            if((solveRec(a.substring(0,k),b.substring(n-k,n))) && (solveRec(a.substring(k,n),b.substring(0,n-k)))){
                test1=true;
            }
            if((solveRec(a.substring(0,k),b.substring(0,k))) && (solveRec(a.substring(k+1,n),b.substring(k+1)))){
                test2=true;
            }
            if(test1 || test2){
                flag=true;
                break;
            }

        }
        return flag;
    }

    public static boolean solveMemo(String a, String b) {
        //Base Case ::
        int n=a.length();
        if(a.equals(b)) return true;
        if(a.length()<=1) return false;
        String key =a+" "+b;
        if(map.containsKey(key)){
            return (boolean)map.get(key);
        }
        //k loop
        boolean flag=false;
        for(int k=1;k<=n-1;k++){
            boolean test1,test2;
            test1 =((solveMemo(a.substring(0,k),b.substring(n-k,n)))&& (solveMemo(a.substring(k,n),b.substring(0,n-k))));
            test2 =((solveMemo(a.substring(0,k),b.substring(0,k))) && (solveMemo(a.substring(k,n),b.substring(k,n))));
            if(test1 || test2){
                flag=true;
                break;
            }

        }
        map.put(key,flag);
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        Boolean res;

//        Recursive
//        res = solveRec(a, b);

        // Memoized
        res = solveMemo(a, b);

        System.out.println(res);
    }
}