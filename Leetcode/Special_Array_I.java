public class Special_Array_I {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (((nums[i] % 2 == 0) && (nums[i+1] % 2 == 0)) || (nums[i] % 2 != 0) && (nums[i+1] % 2 != 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Special_Array_I obj = new Special_Array_I();
        System.out.println(obj.isArraySpecial(new int[]{1,2,3,4,5}));
    }
}
