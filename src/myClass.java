import java.util.*;

class myClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int j = n;
        HashMap<String, Double> mp = new HashMap<>();
        Double total = 0.00;
        // Double avg = 0.00;
        while(j-- > 0) {
            String a = sc.next();
            double b = Double.parseDouble(sc.next());
            double c = Double.parseDouble(sc.next());
            mp.put(a, mp.getOrDefault(a, 0.00) + (b * c));
            total += (b * c);
        }

        String product = "";
        Double max = 0.00;
        for(String k : mp.keySet()) {
            if(mp.get(k) > max) {
                max = mp.get(k);
                product = k;
            }
        }

        System.out.println(total + " " + total / n + " " + product);
    }
}