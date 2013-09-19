public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger prog = new ReverseInteger();
		prog.run();
	}
	public void run() {
		int testInt = 2900;
		int result = reverse(testInt);
		System.out.println("The reverse of " + testInt + " is " + result);
	}

	public int reverse(int val) {
		boolean isNeg = (val < 0);
		if(isNeg) val = Math.abs(val);
		int len = getLen(val);
		int result = 0;
		int digit;
		for(int i = len-1; i >= 0; i--) {
			digit = val / (int) Math.pow(10, i);
			result += digit * (int) Math.pow(10, len - 1 -i);
			val -= digit * (int) Math.pow(10, i);
		}
		return isNeg? (-1)*result : result;
	}

	public int getLen(int val){
		int len = 0;
		while(val != 0){
			len++;
			val /= 10;
		}
		return len;
	}
}
