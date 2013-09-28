public class StringToInt {
	public static void main(String[] args) {
		StringToInt prog = new StringToInt();
		System.out.println(prog.atoi("-0098"));
	}

	public int atoiTest(String s) {
		return Integer.parseInt(s);
	}

	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		str = str.trim();
		if (str.length() == 0) return 0;
		if (str.length() == 1 && !isDigit(str.charAt(0))) return 0;
		if (!isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) != '+') return 0;
		for (int i = 1; i < str.length(); i++) {
			if (!isDigit(str.charAt(i))) return 0;
		}
		boolean isNeg = false;
		if (str.charAt(0) == '+') str = str.substring(1);
		if (str.charAt(0) == '-') isNeg = true;
		if (isNeg) {
			if (str.length() > 11) return 0;
			if (str.length() == 11)
				if (str.substring(1).compareTo("2147483648") > 0) return 0;
		} else {
			if (str.length() > 10) return 0;
			if (str.length() == 10) 
				if (str.compareTo("2147483647") > 0) return 0;
		}
		return Integer.parseInt(str);
	}

	public boolean isDigit(char c) {
		return (c <= '9' && c >= '0');
	}
}
