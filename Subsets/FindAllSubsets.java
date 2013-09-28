import java.util.ArrayList;
import java.util.Iterator;
public class FindAllSubsets {
	public static int SIZE_T = 4;
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		for(int i = 1; i <= SIZE_T; i++) {
			set.add(i);
		}
		ArrayList<ArrayList<Integer>> allSubsets = findSubsets(set, set.size() - 1);
		System.out.println("Size of subsets: " + allSubsets.size());
		printSubsets(allSubsets);

		int[] a = {1, 2};
		printSubsets(subsets(a));
	}
	public static ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if(index < 0) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> subset = new ArrayList<Integer>();
			allSubsets.add(subset);
			return allSubsets;
		}
		allSubsets = findSubsets(set, index - 1);
		ArrayList<ArrayList<Integer>> currSet = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> subset : allSubsets){
			ArrayList<Integer> newset = new ArrayList<Integer>();
			newset.addAll(subset);
			newset.add(set.get(index));
			currSet.add(newset);
		}
		allSubsets.addAll(currSet);
		return allSubsets;
	}

	public static void printSubsets(ArrayList<ArrayList<Integer>> sets) {
		for(ArrayList<Integer> subset : sets) {
			System.out.print('{');
			for(Integer i : subset) {
				System.out.print(i + ", ");
			}
			System.out.println('}');
		}
	}


	  public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        subsets.add(new ArrayList<Integer>());
        if (S == null || S.length == 0) return subsets;
        return findSubsets2(S, 0, subsets);
    }
    
    public static ArrayList<ArrayList<Integer>> findSubsets2(int[] S, int pos, ArrayList<ArrayList<Integer>> subsets) {
        if(pos == S.length) return subsets;
        ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>(subsets);
        for(ArrayList<Integer> set : newSubsets) {
            ArrayList<Integer> newSet = new ArrayList<Integer>(set);
            newSet.add(S[pos]);
            newSubsets.add(newSet);
        }
        return findSubsets2(S, pos + 1, newSubsets);
    }
}
