public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome prog = new LongestPalindrome();
		prog.run();
	}
	public void run() {
		String testString = "bbbb";
		String result = longestPalindrome(testString);
		System.out.println("The longest palindrome of \"" + testString + "\" is \"" + result + "\"");
	}

	public String longestPalindrome(String s) {
		String result = "";
		int offset = 0;
		int len = s.length();
		if(len == 1) return s;
		int pos = 1;
		// case 1, odd number of chars
		while(pos < len - 1) {
			if(result.length() / 2 > len - pos) break;
			while(pos-offset >= 0 && pos+offset < len && s.charAt(pos-offset) == s.charAt(pos+offset)) offset++;
      if(offset*2 - 1 > result.length()) result = s.substring(pos-offset + 1, pos+offset);
			offset = 0;
			pos++;
		}
		// case 2, even number of chars
		pos = result.length() / 2;
		offset = 0;
		while(pos < len-1) {
			if(result.length() / 2 > len - pos) break;
			if(s.charAt(pos) != s.charAt(pos+1)){
				pos++;
				continue;
			}
			while(pos-offset >= 0 && pos+1+offset < len && s.charAt(pos-offset) == s.charAt(pos+offset+1)) offset++;
			if(offset*2 > result.length()) result = s.substring(pos-offset+1, pos+offset+1);
			offset = 0;
			pos++;
		}
		return result;
	}
}
