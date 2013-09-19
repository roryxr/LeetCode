import java.util.Arrays;
public class ThreeSumClosest {
	public static void main(String[] args) {
		ThreeSumClosest prog = new ThreeSumClosest();
		int target = 1;
		int[] num = {-1, 2, 1, -4};
		System.out.println("The closest sum is " + prog.threeSumClosest(num, target));
	}
	
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int closestSum = 0;
		int minDiff = Integer.MAX_VALUE;
		for(int i = 0; i < num.length - 2; i++) {
			int j = i+1, k = num.length - 1;
			while(j < k) {
				int sum = num[i] + num[j] + num[k];
				if(sum <= target) {
					if(target - sum < minDiff){ 
						closestSum = sum;
						minDiff = target - sum;
					}
					j++;
				} else {
					if(sum - target < minDiff) {
						minDiff = sum - target;
						closestSum = sum;
					}
					k--;
				}
			}
		}
			return closestSum;	
	}
}
