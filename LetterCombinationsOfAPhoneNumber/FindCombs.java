import java.util.ArrayList;
public class FindCombs {
	public static void main(String[] args) {
		FindCombs prog = new FindCombs();
		prog.printList(prog.letterCombinations("9"));
	}
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] map = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> combs = new ArrayList<String>();
        int size = 1;
        for (int k = 0; k < digits.length(); k++) size *= map[Character.getNumericValue(digits.charAt(k))].length();
        int i = 0;
        int[] pos = new int[digits.length()];
        while (i < size) {
            String item = "";
            for (int j = 0; j < digits.length(); j++) {
                item += map[Character.getNumericValue(digits.charAt(j))].charAt(pos[j]++);
                if (pos[j] >= map[Character.getNumericValue(digits.charAt(j))].length()) pos[j] = 0;
            }
            i++;
            combs.add(item);
        }
        return combs;
    }
	
	public void printList(ArrayList<String> res) {
		for (String s : res) System.out.print(s + " ");
		System.out.println();
	}
}