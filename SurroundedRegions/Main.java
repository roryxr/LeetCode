import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
			try {
				BufferedReader bs = new BufferedReader(new FileReader("input"));
				String line = null;
				while ((line = bs.readLine()) != null) {
					int size = line.length();
					int n = (int) Math.sqrt(size);
					char[][] map = new char[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							map[i][j] = line.charAt(i * n + j);
						}
					}
					solve(map);
					printMap(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	
	public void printMap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

  public void solve(char[][] board) {
      if(board == null || board.length == 0) return;
      boolean valid;
      for (int i = 0; i < board.length; i++) {
          if (board[i][0] == 'O') update(board, i, 0);
          if (board[i][board[0].length - 1] == 'O') update(board, i, board[0].length - 1);
      }
      for (int i = 0; i < board[0].length; i++) {
          if (board[0][i] == 'O') update(board, 0, i);
          if (board[board.length-1][i] == 'O') update(board, board.length-1, i);
      }
      
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (board[i][j] == 'O') board[i][j] = 'X';
              if (board[i][j] == 'Y') board[i][j] = 'O';
          }
      }
  }
  
  public void update(char[][] board, int i, int j) {
      Queue<Integer> qx = new LinkedList<Integer>();
      Queue<Integer> qy = new LinkedList<Integer>();
      qx.offer(i);
      qy.offer(j);
      while (!qx.isEmpty()) {
          int x = qx.poll(), y = qy.poll();
          board[x][y] = 'Y';
          if (x > 0 && board[x-1][y] == 'O') {
              qx.offer(x-1);
              qy.offer(y);
          }
          if (y > 0 && board[x][y-1] == 'O') {
              qx.offer(x);
              qy.offer(y-1);
          }
          if (x < board.length - 1 && board[x+1][y] == 'O') {
              qx.offer(x+1);
              qy.offer(y);
          }
          if (y < board[0].length - 1 && board[x][y+1] == 'O') {
              qx.offer(x);
              qy.offer(y+1);
          }
      }
  }
	/*
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        boolean valid;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                valid = true;
                if (board[i][j] == 'X') continue;
                if (visited[i][j]) continue;
                if (check(board, visited, i, j)) update(board, i, j);
            }
        }
    }
    
    public boolean check(char[][] board, boolean[][] visited, int i, int j) {
        if (board[i][j] == 'X') return true;
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1) {
            return false;
        }
        if (visited[i][j]) return true;
        visited[i][j] = true;
        if (check(board, visited, i+1, j) && check(board, visited, i, j+1)) return true; //&& check(board, visited, i-1, j) && check(board, visited, i, j-1)) return true;
        return false;
    }
    
    public void update(char[][] board, int i, int j) {
        if (i <= 0 || i >= board.length - 1 || j <= 0 || j >= board[0].length - 1) return;
        if (board[i][j] == 'X') return;
        board[i][j] = 'X';
        update(board, i+1, j);
        update(board, i-1, j);
        update(board, i, j+1);
        update(board, i, j-1);
    }
		*/
}