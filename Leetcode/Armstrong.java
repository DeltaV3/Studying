public class Armstrong {

    public boolean NumArmstrong(int n) {
         String num = String.valueOf(n);
         double sum = 0;
         for (int i = 0; i < num.length(); i++) {
             sum += Math.pow(Integer.parseInt(String.valueOf(num.charAt(i))), num.length());
         }
         return (int) sum == n;
    }

    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        System.out.println(armstrong.NumArmstrong(8028));
    }
}
