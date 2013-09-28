public class ValidPalindrome {
	public static void main(String[] args) {
		ValidPalindrome prog = new ValidPalindrome();
		System.out.println(prog.isPalindrome(""));
	}

	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(s == null || s.length() == 0) return false;
		int i = 0, j = s.length();
		while(i < j) {
			while(i < j && !isAlphabetic(s.charAt(i))) i++;
			while(i < j && !isAlphabetic(s.charAt(j))) j--;
			if(s.charAt(i) != s.charAt(j) && Math.abs(s.charAt(i) - s.charAt(j)) != 32) return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isAlphabetic(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
	}
}
