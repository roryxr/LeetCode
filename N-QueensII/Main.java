public class Main{
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		System.out.println(totalNQueens(4));
	}
	
  public int totalNQueens(int n) {
      int ct = 0;
      int[] list = new int[n];
     	ct = count(n, list, 0, ct);
      return ct;
  }
  
  public int count(int n, int[] list, int i, int ct) {
		//printList(list, i);
      if (i == n) {
				int m = ct + 1;
					//System.out.println("test");
          return m;
      }
      for (int k = 0; k < n; k++) {
				boolean pass = true;
          if (i == 0) {
              list[i] = k;
              ct = count(n, list, i+1, ct);
          } else {
              for (int j = 0; j < i; j++) {
                  if (list[j] == k) {
										pass = false;
                      break;
                  } else if(i - j == Math.abs(k - list[j])) {
										pass = false;
                      break;
                  }
              }
							if (pass) {
                list[i] = k;
                ct = count(n, list, i+1, ct);
							}
          }
      }
      return ct;
  }
	public void printList(int[] list, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}