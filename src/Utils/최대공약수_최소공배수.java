package Utils;

public class 최대공약수_최소공배수 {
    public static void main(String[] args) {
        System.out.printf("최대공약수: %d\n", my_gcd(4, 6));
        System.out.printf("최소공배수: %d", my_lcm(4, 6));
    }

    private static int my_lcm(int a, int b) {
        return ((a * b) / my_gcd(a, b));
    }

    public static int my_gcd(int a, int b){
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        while (smaller != 0){
            int r = bigger % smaller;

            bigger = smaller;
            smaller = r;
        }

        return bigger;
    }
}
