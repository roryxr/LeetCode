class UndirectedGRaphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	public static void main(String[] args) {
		CloneGraph prog = new CloneGraph();
		prog.run();
	}
	
	public void run() {
		UndirectedGraphNode n = new UndirectedGrpahNode(0);
		n.neighbors.add(n);
		n.neighbors.add(n);
	}
	
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      if (node == null) return null;
      UndirectedGraphNode res = new UndirectedGraphNode(node.label);
      HashSet<Integer> visitList = new HashSet<Integer>();
      clone(node, res, visitList);
      return res;
  }
  
  public void clone(UndirectedGraphNode node, UndirectedGraphNode res, HashSet<Integer> visitList) {
          if (!visitList.contains(node.label)) {
              visitList.add(node.label);
              for (UndirectedGraphNode n : node.neighbors) {

                  UndirectedGraphNode nb = new UndirectedGraphNode(n.label);
                  res.neighbors.add(nb);
              }
              for (int i = 0; i < node.neighbors.size(); i++) {
                  if (!visitList.contains(node.neighbors.get(i).label)) {
                      clone(node.neighbors.get(i), res.neighbors.get(i), visitList);
                  }
              }
          }
  }
}