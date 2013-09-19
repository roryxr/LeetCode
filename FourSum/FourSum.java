mport java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
public class FourSum {
	public static void main(String[] args) {
		FourSum prog = new FourSum();
		int[] array  = {1, 0, -1, 0, -2, 2};
		int target = 0;
		ArrayList<ArrayList<Integer>> result = prog.fourSum(array, target);
		prog.printList(result);
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] a, int target) {
		Arrays.sort(a);
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		for(int i = 0; i < a.length - 3; i++) {
				for(int j = a.length - 1; j >= i + 3; j--) {
					int m = i + 1, n = j - 1;
					while(m < n) {
						int sum =  a[i] + a[j] + a[m] + a[n];
						if(sum > target) n--;
						else if(sum < target) m++;
						else {
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(a[i]);
							list.add(a[m]);	
							list.add(a[n]);
							list.add(a[j]);
							m++;	
							n--;
							result.add(list);
						}
					}
				}
		}

		ArrayList<ArrayList<Integer>> copy = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> k : result) copy.add(k);
		return copy;
	}

	public void printList(ArrayList<ArrayList<Integer>> x) {
		for(ArrayList<Integer> list : x) {
			System.out.print("[");
			for(int i = 0; i < list.size() - 1; i++) {
				System.out.print(list.get(i) + ", ");
			}
			System.out.println(list.get(list.size()-1) + "]");
		}
	}
}
