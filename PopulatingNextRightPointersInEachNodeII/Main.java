import java.util.ArrayList;
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {val = x;}
}

public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	public void run() {
		ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		for (int i = 0; i < 8; i++) {
			TreeLinkNode n = new TreeLinkNode(i+1);
			list.add(n);
		}
		list.get(0).left = list.get(1);
		list.get(0).right = list.get(2);
		list.get(1).left = list.get(3);
		list.get(1).right = list.get(4);
		list.get(2).right = list.get(5);
		list.get(3).left = list.get(6);
		list.get(5).right = list.get(7);
		connect(list.get(0));
		printTree(list.get(0));
	}
	
  public void connect(TreeLinkNode root) {
      if (root == null) return;
      root.next = null;
      helper(root, root.right);
      helper(root, root.left);
  }
  
  public void helper(TreeLinkNode p, TreeLinkNode n) {
      if (n == null) return;
      if (p.right != null && p.right != n) {
          n.next = p.right;
      } else {
          TreeLinkNode curr = p.next;
					//System.out.println("start");
          while (curr != null) {
						//System.out.print(curr.val + "->");
              if (curr.left != null) {                        
                  n.next = curr.left;
                  break;
              } else if (curr.right != null) {
                  n.next = curr.right;
                  break;
              }
              curr = curr.next;
          }
					//System.out.println();
      }
      helper(n, n.right);
      helper(n, n.left);
  }
	public void printTree(TreeLinkNode root) {
		TreeLinkNode currHead = root;
		while (currHead != null) {
			TreeLinkNode curr = currHead;
			while (curr != null) {
				System.out.print(curr.val+", ");
				curr = curr.next;
			}
			System.out.print("#, ");
			currHead = currHead.left;
		}
	}
}