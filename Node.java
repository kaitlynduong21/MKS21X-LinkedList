public class Node{
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
}
