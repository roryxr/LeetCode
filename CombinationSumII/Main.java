import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		int[] num = new int[2];
		num[0] = 1;
		num[1] = 1;
		printList(combinationSum2(num, 1));
	}
	
	public void printList(ArrayList<ArrayList<Integer>> res) {
		for (ArrayList<Integer> list : res) {
			System.out.print("[");
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println("]");
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        Arrays.sort(num);
	        boolean[] used = new boolean[num.length];
	        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
	        find(num, used, target, res, 0);
	        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
	        for (ArrayList<Integer> list : res) {
	            output.add(list);
	        }
	        return output;
	    }
    
	    public void find(int[] num, boolean[] used, int target, HashSet<ArrayList<Integer>> res, int pos) {
	        if (target == 0) {
						System.out.println(pos);
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            for (int i = 0; i < pos; i++) {
	                if (used[i]) list.add(num[i]);
	            }
	            res.add(list);
	            return;
	        }
	        if (pos == num.length) return;
        
	        for (int i = pos; i < num.length; i++) {
	            if (num[i] > target) break;
	            target = target - num[i];
	            used[i] = true;
	            find(num, used, target, res, i+1);
	            target += num[i];
	            used[i] = false;
	        }
	    }
}