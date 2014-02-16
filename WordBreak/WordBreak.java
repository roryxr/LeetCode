import java.util.HashSet;
import java.util.Set;
public class WordBreak {
	public static void main(String[] args) {
		WordBreak prog = new WordBreak();
		prog.run();
	}
	
	public void run() {
		String s = "aab";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		System.out.println(wordBreak(s, set));
	}
	
  public boolean wordBreak(String s, Set<String> dict) {
      boolean[] possible = new boolean[s.length()];
			if (s == null || s.length() == 0) return false;
      for (int i = 0; i < s.length(); i++) {
          if (dict.contains(s.substring(0, i+1))) possible[i] = true;
          else {
              for (int j = 0; j < i; j++) {
                  if (possible[j] && wordBreak(s.substring(j+1, i+1), dict)) {
                      possible[i] = true;
                      break;
                  }
              }
          }
      }
      return possible[s.length() - 1];
  }
}