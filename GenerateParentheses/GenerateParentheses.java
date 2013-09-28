import java.util.ArrayList;
public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses prog = new GenerateParentheses();
		ArrayList<String> res = prog.generateParenthesis(3);
		prog.printList(res);
	}

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		char[] charA = new char[n*2];
		return helper(res, n, n, charA, 0);
	}

	public ArrayList<String> helper(ArrayList<String> res, int leftRemain, int rightRemain, char[] charA, int pos) {
		if (leftRemain == 0 && rightRemain == 0) {
			res.add(new String(charA));
			return res;
		}

		if (leftRemain > 0) {
			charA[pos] = '(';
			res = helper(res, leftRemain-1, rightRemain, charA, pos+1);
		}

		if (rightRemain > 0 && rightRemain > leftRemain) {
			charA[pos] = ')';
			res = helper(res, leftRemain, rightRemain-1, charA, pos+1);
		}
		return res;
	}

	public void printList(ArrayList<String> list) {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
