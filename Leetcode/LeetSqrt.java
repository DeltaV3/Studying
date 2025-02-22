public class LeetSqrt {

    public int mySqrt(int x) {
        x = (int) Math.abs(Math.sqrt(x));
        return x;
    }

    public static void main(String[] args) {
        LeetSqrt leet = new LeetSqrt();
        System.out.println(leet.mySqrt(8));
    }
}
