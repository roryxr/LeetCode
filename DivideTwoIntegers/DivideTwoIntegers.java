public class DivideTwoIntegers {
	public static void main(String[] args) {
		DivideTwoIntegers prog = new DivideTwoIntegers();
		int dividend = -2147483648;
		int divisor = 1;
		System.out.println("Result = " + prog.divide(dividend, divisor));
	}

	public int divide(int dividend, int divisor) {
		long x = Math.abs((long)dividend);
		long y = Math.abs((long)divisor);
		long res = 0;
		while(x >= y) {
			long c = y;
			for(int i = 0; x >= c; ++i, c <<= 1) {
				x -= c;
				res += 1 << i;
			}
		}
		return (((dividend ^ divisor) >> 31) == -1) ? (-(int)res):((int)res);
	}
}
