import java.lang.StringBuffer;
public class ZigZag {
	public static void main(String[] args) {
		ZigZag prog = new ZigZag();
		prog.run();
	}

	public void run() {
		String testString = "A";
		int nRows = 1;
		String result = convert(testString, nRows);
		System.out.println("The convert of \"" + testString + "\" of " + nRows + " rows is \"" + result + "\"");
	}

	public String convert(String s, int n) {
		if(n == 1) return s;
		int len = s.length();
		int gap = n * 2 - 2;
		int[] offset = new int[2];
		int trigger;
		int pos = 0;
		int index;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < n; i++) {
			index = i;
			trigger = 0;
			if(i == 0 || i == n-1) {
				while(index < len) {
					sb.append(s.charAt(index));
					index += gap;
				}
			} else {
				offset[0] = gap - 2 * i;
				offset[1] = 2 * i;
				while(index < len) {
					sb.append(s.charAt(index));
					index += offset[trigger];
					trigger = 1- trigger;
				}
			}
		}
		return sb.toString();
	}
}
