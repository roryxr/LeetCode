import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		String s = "aabaaaa";
		ArrayList<ArrayList<String>> res = partition(s);
		printResult(res);
	}
	public void printResult(ArrayList<ArrayList<String>> res) {
		for (ArrayList<String> list : res) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

  public ArrayList<ArrayList<String>> partition(String s) {
		boolean[][] isPa = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {	
			isPa[i][i] = true;
		}
		for (int i = s.length() - 2; i >= 0; i--) {
			isPa[i][i+1] = (s.charAt(i) == s.charAt(i+1));
			for (int j = i + 2; j < s.length(); j++) {
				isPa[i][j] = (s.charAt(i) == s.charAt(j) && isPa[i+1][j-1]);
			}
		}
		ArrayList<ArrayList<String>> res = null;
		res = Helper(s, isPa, 0);
		return res;
  }
	
	public ArrayList<ArrayList<String>> Helper(String s, boolean[][] isPa, int pos) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (pos == s.length()) {
			ArrayList<String> list = new ArrayList<String>();
			res.add(list);
			return res;
		}
		
		for (int i = pos; i < s.length(); i++) {
			if (isPa[pos][i]) {
				for (ArrayList<String> subPa : Helper(s, isPa, i+1)) {
					subPa.add(0, s.substring(pos, i+1));
					res.add(subPa);
				}
			}
		}
		return res;
	}
}