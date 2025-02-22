import java.util.HashMap;

public class Two_Sum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int complement;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Two_Sum two_Sum = new Two_Sum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = two_Sum.twoSum(nums,target);
        System.out.println("Índices: [" + result[0] + ", " + result[1] + "]");
    }
}
