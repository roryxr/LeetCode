import java.util.ArrayList;
public class Main{
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		ArrayList<String[]> res = solveNQueens(4);
		for (String[] as : res) {
			System.out.print("[");
			for (String s : as) {
				System.out.print(s+ " ");
			}
			System.out.println("]");
		}
	}
	
  public ArrayList<String[]> solveNQueens(int n) {
      ArrayList<String[]> res = new ArrayList<String[]>();
      int[] list = new int[n];
      res = getSol(n, list, 0, res);
      return res;
  }
	
  public ArrayList<String[]> getSol(int n, int[] list, int k, ArrayList<String[]> res) {
		printList(list, k);
			if (k == n) {
				System.out.println("test");
          String[] as = new String[n];
          for (int i = 0; i < n; i++) {
              StringBuffer sb = new StringBuffer();
              for (int j = 0; j < n; j++) {
                  if (j == list[i]) {
                      sb.append('Q');
                  } else {
                      sb.append('.');
                  }
              }
              as[i] = new String(sb);
          }
          res.add(as);
          return res;
      }
      boolean pass = true;
      for (int i = 0; i < n; i++) {
				pass = true;
          if (k == 0) {
              list[k] = i;
              res = getSol(n, list, k+1, res);
          } else {
              for (int j = 0; j < k; j++) {
                  if (list[j] == i) {
                      pass = false;
                      break;
                  } else if (k - j == Math.abs(i - list[j])) {
                      pass = false;
                      break;
                  }
              }
              if (pass) {
                  list[k] = i;
                  res = getSol(n, list, k+1, res);
              }
          }
      }
      return res;
  }
	public void printList(int[] list, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}