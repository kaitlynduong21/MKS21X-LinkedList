public class MyLinkedList{

  private class Node{
    private Integer data;
    private Node next,prev;

    public Node (int a, Node nextref, Node prevref) {
      data = a;
      next = nextref;
      prev = prevref;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }
    public void setNext(Node other) {
      next = other;
    }

    public void setPrev(Node other) {
      prev = other;
    }

    public Integer getData() {
      return data;
    }

    public Integer setData(Integer i) {
      Integer old = data;
      data = i;
      return old;
    }

    public String toString() {
      String s = "";
      s += getData();
      return s;
    }

  }

  private int size;
  private Node start,end;

  public boolean add(Integer value) {
    Node n = new Node(value, end, null);
    end = n;
    return true;
  }

  public int size() {
    return size;
  }

  public String toString() {
    
  }   //note you don't have get(index) yet, nor would you want to use it here


  public Integer get(int index){

  }

  public Integer set(int index,Integer value) {

  }

  public boolean contains(Integer value) {

  }

  public int indexOf(Integer value) {

  }

  public void add(int index,Integer value) {

  }

  public Integer remove(int index) {

  }

  public Integer remove(Integer value) {

  }
}
