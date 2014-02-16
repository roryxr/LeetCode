import java.util.ArrayList;
import java.util.HashMap;
class Point {
	int x;
	int y;
	Point() { x = 0; y = 0;}
	Point(int a, int b) {x = a; y = b;}
}

public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		int[] xval = {0,5,2,0,1,2,5,3,-2,-1,0,0,-2,0,0};
		int[] yval = {-12,2,5,-5,5,-2,-4,4,4,4,-5,-8,-1,-11,-9};
		Point[] input = new Point[xval.length];
		for (int i = 0; i < xval.length; i++) {
			input[i] = new Point(xval[i], yval[i]);
		}
		System.out.println(maxPoints(input));
	}
	
  public int maxPoints(Point[] points) {
      if (points == null || points.length == 0) return 0;
      int max = 1;
      HashMap<Double, ArrayList<Point>> curve = new HashMap<Double, ArrayList<Point>>();
      HashMap<Integer, ArrayList<Point>> vertical = new HashMap<Integer, ArrayList<Point>>();
      HashMap<Integer, ArrayList<Point>> horizontal = new HashMap<Integer, ArrayList<Point>>();
      for (int i = 0; i < points.length - 1; i++) {
          for (int j = i+1; j < points.length; j++) {
              int dx = points[j].x - points[i].x, dy = points[j].y - points[i].y;
              if (dx == 0) {
                  if (vertical.containsKey(points[i].x)) {
                      ArrayList<Point> list = vertical.get(points[i].x);
                      int ct = list.size();
                      if (!list.contains(points[i])) {
                          ct++;
                          list.add(points[i]);
                      }
                      if (!list.contains(points[j])) {
                          ct++;
                          list.add(points[j]);
                      }
                      if (ct > max) max = ct;
                  } else {
                      ArrayList<Point> list = new ArrayList<Point>();
                      list.add(points[i]);
                      list.add(points[j]);
                      vertical.put(points[i].x, list);
                      if (2 > max) max = 2;
                  }
              } else if (dy == 0) {
                  if (horizontal.containsKey(points[i].y)) {
                      ArrayList<Point> list = horizontal.get(points[i].y);
                      int ct = list.size();
                      if (!list.contains(points[i])) {
                          ct++;
                          list.add(points[i]);
                      }
                      if (!list.contains(points[j])) {
                          ct++;
                          list.add(points[j]);
                      }
                      if (ct > max) max = ct;
                  } else {
                      ArrayList<Point> list = new ArrayList<Point>();
                      list.add(points[i]);
                      list.add(points[j]);
                      horizontal.put(points[i].y, list);
                      if (2 > max) max = 2;
                  }               
              } else {
                  double k = dy*1.0 / dx;
                  if (curve.containsKey(k)) {
                      ArrayList<Point> list = curve.get(k);
                      int ct = list.size();
                      if (!list.contains(points[i])) {
                          ct++;
                          list.add(points[i]);
                      }
                      if (!list.contains(points[j])) {
                          ct++;
                          list.add(points[j]);
                      }
                      if (ct > max) max = ct;
                  } else {
                      ArrayList<Point> list = new ArrayList<Point>();
                      list.add(points[i]);
                      list.add(points[j]);
                      curve.put(k, list);
                      if (2 > max) max = 2;
                  }	
              }
          }
      }
			printMap1(curve);
			printMap2(vertical);
			printMap2(horizontal);
      return max;
  }	
	
	public void printMap1(HashMap<Double, ArrayList<Point>> map) {
		System.out.println("printing map1");
		for (Double i : map.keySet()) {
			System.out.print(i + ": ");
			for (Point p : map.get(i)) {
				System.out.print("[" + p.x + ", " + p.y + "] ");
			}
			System.out.println();
		}
	}
	
	public void printMap2(HashMap<Integer, ArrayList<Point>> map) {
		System.out.println("printing map2");
		for (Integer i : map.keySet()) {
			System.out.print(i + ": ");
			for (Point p : map.get(i)) {
				System.out.print("[" + p.x + ", " + p.y + "] ");
			}
			System.out.println();
		}
	}
	
}


/*
        if (points == null || points.length == 0) return 0;
        double[][] record = new double[points.length][points.length];
        int[][] type = new int[points.length][points.length];
        
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i+1; j < points.length; j++) {
                int dx = points[j].x - points[i].x, dy = points[j].y - points[i].y;
                if (dx == 0 || dy == 0) {
                    if (dx == 0) {
                        if (dy == 0) {
                            type[i][j] = 4;
                        } else {
                            type[i][j] = 1;
                            record[i][j] = points[i].x;
                        }
                    } else {
                        type[i][j] = 2;
                        record[i][j] = points[i].y;
                    }
                } else {
                    type[i][j] = 3;
                    record[i][j] = dy / dx;
                }
            }
        }
        

*/