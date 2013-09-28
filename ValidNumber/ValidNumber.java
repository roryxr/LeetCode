public class ValidNumber {
	public static void main(String[] args) {
		ValidNumber prog = new ValidNumber();
		System.out.println(prog.isNumber("11"));
	}

	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s = s.trim();
		int cnt1 = 0;
		int cnt2 = 0;
		int pos1 = 0;
		int pos2 = 0;
		if(s == null || s.length() == 0) return false;
		if(s.length() == 1) {
			if(Character.isDigit(s.charAt(0))) return true;
			else return false;
		} else {
			if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
			if(!Character.isDigit(s.charAt(s.length() - 1)) && s.charAt(s.length() - 1) != '.') return false;
			if(s.length() == 1 && s.charAt(0) == '.') return false;
			else {
				if(s.charAt(0) == 'e') return false;
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == 'e') {
						cnt1++;
						pos1 = i;
						if (cnt1 > 1) return false;
					} else if(s.charAt(i) == '.') {
						cnt2++;
						pos2 = i;
						if(cnt2 > 1) return false;
					} else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
						if(i == 0) return false;
						else {
							if(s.charAt(i - 1) != 'e') return false;
						}
					} else {
						if(!Character.isDigit(s.charAt(i))) return false;
					}
				}
				if(cnt1 > 0 && cnt2 > 0) {
					if(pos2 == pos1 - 1 && pos2 != 0) return true;
					else if(pos2 < pos1 - 1) return true;
					else return false;
				}
			}
		}
		return true;
	}

}
