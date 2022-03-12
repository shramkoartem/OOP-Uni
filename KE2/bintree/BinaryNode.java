package KE2.bintree;

public class BinaryNode{
  private BinaryNode leftChild, rightChild;
  private int value;

  public BinaryNode(int v){
    this.value=v;
  }

  public boolean contains(int v){
    if(this.value == v){
      return true;
    } else {
      if (this.leftChild != null) this.leftChild.contains(v);
      if (this.rightChild != null) this.rightChild.contains(v);
    }
    return false;
  }

  public void insert(int v){
    if (this.value == v) { return ;}
    if (v < this.value){
      if (this.leftChild == null) {
        this.leftChild = new BinaryNode(v);
      } else {
        this.leftChild.insert(v);
      }
    } else {
      if (this.rightChild == null) {
        this.rightChild = new BinaryNode(v);
      } else {
        this.rightChild.insert(v);
      }
    }
  }
  
  public void inorder(){
    if(this.leftChild != null) this.leftChild.inorder();
    System.out.println(this.value);
    if(this.rightChild != null) this.rightChild.inorder();
  }
}
