import java.util.ArrayList;
//import java.lang.Object;
public class test {
	public static void main(String[] args) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		System.out.println(res.hashCode());
		res.add(23);
		res.add(2);
		System.out.println(res.hashCode());
		ArrayList<Integer> lol = new ArrayList<Integer>();
		lol.add(23);
		lol.add(2);
		System.out.println(lol.hashCode());
		//System.out.println(hashCode(res));
	}
}