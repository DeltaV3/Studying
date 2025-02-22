public class Make_All_Elements_Divisible_by_Three {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0) {
            } else{
                operations++;
            }
        }
        return operations;
    }
}
