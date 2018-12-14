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

  public MyLinkedList () {
    size = 0;
  }

  public boolean add(Integer value) {
    if (size == 0) {
      Node n = new Node(value, null, null);
      end = n;
      start = n;
    } else {
      Node n = new Node(value, end, null);
      end = n;
      n.prev.setNext(n);
      System.out.println(n.prev.getData());
  }
    size ++;
    return true;
  }

  public int size() {
    return size;
  }

  public String toString() {
    if (size == 0) {
      return "[]";
    }
    String s = "[";
    /*for (int i = 0; i < size - 1; i ++) {
      s += start.getData() += ", ";
    }*/
    return s += "]";
  }   //note you don't have get(index) yet, nor would you want to use it here


  /*public Integer get(int index){

  }

  public Integer set(int index,Integer value) {

  }

  public boolean contains(Integer value) {

  }

  public int indexOf(Integer value) {

  }

  public void add(int index,Integer value) {
    Node n = new Node (value, this.get(index), this.get(index + 1));
    this.get(index).next = n;
    this.get(index + 1).prev = n;
  }

  public Integer remove(int index) {

  }

  public Integer remove(Integer value) {

  }*/

  public static void main(String[] args) {
      //What's poppin' everybody, welcome to my driver, we chill here in the code house
      //Let's test this class and get this bread

      //Step One: Creating a valid Instance
      System.out.println("######################");
      System.out.println("##New Instance Test:##");
      System.out.println("######################");
      MyLinkedList list = new MyLinkedList();
      System.out.println(list);
      System.out.println("This should print: \"[]\"\n");

      //Step Two: Let's add some values
      System.out.println("#######################");
      System.out.println("##Adding Values Test:##");
      System.out.println("#######################");
      for(int i = 0; i < 10; i++) {
          list.add(i);
          System.out.println(list.size()); //<- Debugging
      }
      System.out.println(list);
      System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");
    }
}
