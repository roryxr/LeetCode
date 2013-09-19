import java.util.ArrayList;
public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle prog = new PascalsTriangle();
		int numRows = 8;
		prog.printList(prog.generate(numRows));
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < numRows; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) list.add(1);
				else list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
			}
			result.add(list);
		}
		return result;
	}

	public void printList(ArrayList<ArrayList<Integer>> result) {
		for(ArrayList<Integer> list : result) {
			System.out.print("[");
			for(int i = 0; i < list.size() - 1; i++) System.out.print(list.get(i) + ", ");
			System.out.println(list.get(list.size() - 1) + "]");
		}
	} 
}	
