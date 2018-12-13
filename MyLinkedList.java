public class MyLinkedList{

  private class Node{
   private int data;
   private Node next,prev;

   public Node (int a, Node nextref, Node prevref) {
     data = a;
     next = nextref;
     prev = prevref;
   }

   public int getData() {
     return data;
   }

   public Node next() {
     return next;
   }
    Node prev()
    void setNext(Node other)
    void setPrev(Node other)
    Integer getData()
    Integer setData(Integer i)
    String toString()

  }

 private int size;
 private Node start,end;

 public int size() {
   get size;

 }
 public boolean add(int value);
 public String toString();
}
