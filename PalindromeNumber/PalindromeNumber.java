public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber prog = new PalindromeNumber();
		prog.run();
	}
	public void run() {
		int i = -2147447412;
		System.out.println(i + (isPalindrome(i) ? " is " : " is not ") + "Palindrome Number");
	}

	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
				long k = x;
				if(k < 0 ) k = (-1) * k;
				System.out.println(k + " " + len(k));
        for(int i = len(k) - 1; i >= 0; i--) {
					
            //System.out.println((k % (int)Math.pow(10, i+1)) / (int) Math.pow(10, i) + " " + (k % (int)Math.pow(10, len(k)-i)) / (int) Math.pow(10, len(k)-i-1));
            if((k % (int)Math.pow(10, i+1)) / (int) Math.pow(10, i) != (k % (int)Math.pow(10, len(k)-i)) / (int) Math.pow(10, len(k)-i-1)) return false;
        }
        return true;
    }
    
    public int len(long x) {
        int count = 0;
        while(x > 0) {
            x /= 10;
            count++;
        }
        return count;
    }
}
