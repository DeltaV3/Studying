public class Concatenation_Array {

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        int cont = nums.length;
        for (int j = 0; j < nums.length; j++) {
            result[cont] = nums[j];
            cont++;
        }
        return result;
    }

    public static void main(String[] args) {
        Concatenation_Array obj = new Concatenation_Array();
        int[] nums = obj.getConcatenation(new int[]{1, 2, 1});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
