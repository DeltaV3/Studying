public class Richest_Customer_Wealth {

    public int maximumWealth(int[][] accounts) {
        int mayor = 0;
        int sum = 0;
        for (int i = 0; i < accounts.length; i++) {
            sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
                if (sum > mayor) {
                    mayor = sum;
                }
            }
        }
        return mayor;
    }

    public static void main(String[] args) {
        Richest_Customer_Wealth r = new Richest_Customer_Wealth();
        int[][] accounts = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(r.maximumWealth(accounts));
    }
}
