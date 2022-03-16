package KE3.countries;
import KE3.countries.GraphException;

public class Graph {

  protected boolean[][] adjacencyMatrix;
  protected String[] nodes;

  protected int indexOf(String node) throws GraphException {
    for (int i = 0; i< nodes.length; i++){
      if (node.equals(nodes[i])){
        return i;
      }
    }
    throw new GraphException();
  }


  public Graph(int nodeNumber) {
    nodes = new String[nodeNumber];
    adjacencyMatrix = new boolean[nodeNumber][nodeNumber];
  }

  public Graph(String[] nodes) {
    this(nodes.length); // constructor
    for (int i = 0; i<nodes.length; i++){
      this.nodes[i] = nodes[i]; 
    }
  }

  public String getNode(int index) throws GraphException {
    if (index >= 0 && index < this.nodes.length){
      return this.nodes[index];
    }
    throw new GraphException();
  }

  public int getNumberOfNodes() {
    return this.nodes.length;
  }

  public void setNodes(String[] nodes) {
    int k = Math.min(nodes.length, this.nodes.length);
    for (int i=0; i<k; i++){
      this.nodes[i] = nodes[i];
    }
  }

  public boolean isAdjacent(int index1, int index2) throws GraphException {
    if(index1 <= nodes.length && index2 <= nodes.length){
      return adjacencyMatrix[index1][index2];
    }
    throw new GraphException();
  }

  public boolean isAdjacent(String node1, String node2) throws GraphException {
    int index1 = this.indexOf(node1);
    int index2 = this.indexOf(node2);

    return isAdjacent(index1, index2);
  }

  public void addEdge(int index1, int index2) throws GraphException {
    if (index1 <= nodes.length && index2 <= nodes.length){
      adjacencyMatrix[index1][index2] = true;
    }
    throw new GraphException();
  }

  public void addEdge(String node1, String node2) throws GraphException {
    int index1 = this.indexOf(node1);
    int index2 = this.indexOf(node2);
    addEdge(index1, index2);
  }

} 



