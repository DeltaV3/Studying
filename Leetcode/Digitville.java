public class Digitville {
    public int[] getSneakyNumbers(int[] nums) {
        int[] sneakyNumbers = new int [2];
        int numbers = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (numbers == 0) {
                        sneakyNumbers[numbers] = nums[i];
                        numbers++;
                    }else {
                        if (numbers == 1){
                            sneakyNumbers[numbers] = nums[i];
                        }
                    }
                }
            }
        }
        return sneakyNumbers;
    }
}
