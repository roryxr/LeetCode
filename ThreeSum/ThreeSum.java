import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum prog = new ThreeSum();
		int[] array = {-1, 0, 1, 2, -1, -4};
		HashSet<ArrayList<Integer>> result = prog.threeSum(array);
		prog.printResult(result);
	}

	public void printResult(HashSet<ArrayList<Integer>> result) {
		for(ArrayList<Integer> list : result) {
			System.out.print("[");
			for(int i = 0; i < list.size() - 1; i++) {
				System.out.print(list.get(i) + ", ");
			}
			System.out.println(list.get(list.size() - 1) + "]");
		}
	}

	public HashSet<ArrayList<Integer>> threeSum(int[] a) {
			Arrays.sort(a);
			HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
			
			for(int i = 0; i < a.length - 2; i++) {
				int j = i + 1, k = a.length - 1;
				while(j < k) {
					int sum = a[i] + a[j] + a[k];
					if(sum < 0) j++;
					else if(sum > 0) k--;
					else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(a[i]);
						list.add(a[j]);
						list.add(a[k]);
						result.add(list);
						j++;
					}
				}
			}
			return result;
	}

	
}
