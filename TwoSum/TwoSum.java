public class TwoSum {
	public static void main(String[] args) {
		int[] a = {2, 4, 7, 11, 8, 10, 19};
		int[] result;
		int target = 9;
		result = twoSum(a, target);
		if(result != null)
			System.out.println("Indice of two values whose sum is " + target + " are " + result[0] + " and " + result[1]);
		else
			System.out.println("Result cannot be found");
	}

    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if((numbers[i] + numbers[j]) == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }
        // did not find
        return null;
    }
}
