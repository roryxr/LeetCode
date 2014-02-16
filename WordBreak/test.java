import java.util.ArrayList;
public class test {
	public static void main(String[] args) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		run(res, 0);
	}
	
	public static void run(ArrayList<Integer> res, int pos) {
		if (pos == 10) {
			res.add(0, pos);
			return;
		}
		run(res, pos+1);
		printList(res);
		res.add(0, pos);
		return;
	}
	
	public static void printList(ArrayList<Integer> res) {
		for (Integer i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}