import java.util.LinkedList;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Main {
	public static void main(String[] args) {
		Main prog = new Main();
		prog.run();
	}
	
	public void run() {
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 1, 3};
		TreeNode head = buildTree(preorder, inorder);
		printTree(head);
	}
	
	public void printTree(TreeNode head) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		if (head == null) {
			System.out.println("{}");
			return;
		}
		q.offer(head);
		System.out.print("{" + head.val + ", ");
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode n = q.poll();
				if (n.left != null) {
					System.out.print(n.left.val + ", ");
					q.offer(n.left);
				} else {
					System.out.print("#, ");
				}
				if (n.right != null) {
					System.out.print(n.right.val + ", ");
					q.offer(n.right);
				} else {
					System.out.print("#, ");
				}
			}
		}
		System.out.println("}");
	}
	
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      int i = 0, j = 0;
      if (preorder.length == 0) return null;
      TreeNode head = null;
      LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
      while (i < preorder.length) {
				// System.out.println(i);
          if (stack.isEmpty()) {
              head = new TreeNode(preorder[i++]);
              stack.push(head);
          } else {
              TreeNode n = new TreeNode(preorder[i++]);
							//System.out.println(stack.peek().val + ", " + inorder[j]);
              if (stack.peek().val == inorder[j]) {
                  TreeNode last = stack.pop();
									//System.out.println(last.val);
                  if (stack.size() > 0) {
										//System.out.println(stack.peek().val);
                      if (inorder[j+1] != stack.peek().val) {
                          last.right = n;
                          stack.push(n);
                      } else {
                      	stack.peek().right = n;
												stack.push(n);
                      }
                  } else {
                      last.right = n;
                      stack.push(n);
                  }
                  j++;
              } else {
                  stack.peek().left = n;
                  stack.push(n);
              }
          }
      }
      return head;
  }
}