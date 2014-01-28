mport java.util.HashSet;
public class FindLongestSubstring {
	public static void main(String[] args) {
		String testString = "bacssasdbas";
		String result = findLongestSubstring(testString);
		System.out.println("The longest substring of \"" + testString + "\" is \"" + result + "\"");
	}

	public static String findLongestSubstring(String s) {
		HashSet<Character> charSet = new HashSet<Character>();
		int left = 0, right = 0;
		String result = "";
		String temp = "";
		while(right != s.length()) {
			while(right != s.length() && !charSet.contains(s.charAt(right))) {
				charSet.add(s.charAt(right));
				temp += s.charAt(right++);
			}
			if(temp.length() > result.length()) result = "" + temp;
			if(right != s.length()) {
				int newleft = s.indexOf(s.charAt(right), left);
				for(int i = left; i < newleft; i++) charSet.remove(s.charAt(i));
				left = newleft + 1;
				temp = "";
				for(int i = left; i <= right; i++) temp += s.charAt(i);
				right++;
			}
		}
		if(temp.length() > result.length()) result = "" + temp;
		return result;
	}
}
