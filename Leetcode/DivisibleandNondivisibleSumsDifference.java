public class DivisibleandNondivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int divisibleSum = 0, undivisibleSum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % m == 0) {
                divisibleSum += i;
            }else{
                undivisibleSum += i;
            }
        }
        return undivisibleSum - divisibleSum;
    }

    public static void main(String[] args) {
        DivisibleandNondivisibleSumsDifference a  = new DivisibleandNondivisibleSumsDifference();
        System.out.println(a.differenceOfSums(10, 3));
    }
}
