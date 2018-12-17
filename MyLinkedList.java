

public class MyLinkedList{

  private class Node{
    private Integer data;
    private Node next,prev;

    public Node (Integer a, Node nextref, Node prevref) {
      data = a;
      next = nextref;
      prev = prevref;
    }

    public Node (Integer a) {
      data = a;
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
      end = n; // set both the start and end refer to the new node if the list is empty
      start = n;
    } else {
      Node n = new Node(value, end, null);
      end.setNext(n); // set the end refer to the new node
      end = n; //set the end to the new node
  }
    size ++;
    return true;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "[";
    Node current = start;
    int i = 0;
    while (i < size) {
      s = s + current.getData();
      current = current.next();
      if (i < size - 1) {
        s += ", ";
      }
      i ++;
    }
    return s += "]";
  }   //note you don't have get(index) yet, nor would you want to use it here


  public Integer get(int index){
      Node current = start;
      int i = 0;
      while (i < size) {
        if (i == index) {
          return current.getData();
        }
        i ++;
        current = current.next();
      }
    throw new IndexOutOfBoundsException("Index cannot be negative or is greater than the size");
  }

  public Integer set(int index,Integer value) {
    Node current = start;
    int i = 0;
    while (i < size) {
      if (i == index) {
        int old = current.getData();
        current.setData(value);
        return old;
      }
      i ++;
      current = current.next();
    }
    throw new IndexOutOfBoundsException("Index cannot be negative or is greater than the size");
  }

 public boolean contains(Integer value) {
   Node current = start;
   int i = 0;
   while (i < size) {
     if (current.getData() == value) {
       return true;
     }
     i ++;
     current = current.next();
   }
   return false;
  }

  public int indexOf(Integer value) {
    Node current = start;
    int index = 0;
    while (index < size) {
      if (current.getData() == value) {
        return index;
      }
      index ++;
      current = current.next();
    }
    return -1; // return -1 if this list does not contain the element
  }

  public void add(int index, Integer value) {
    Integer x = end.getData();
    Node current = start;
    int i = 0;
    if (index == 0) {
      Node n = new Node (value, start, null);
      start = n;
      size++;
    }
    while (i < size) {
      //System.out.println(this.toString());
      if (i == index - 1) {
        //System.out.println("works");
        Node n = new Node (value, current.next(), current);
        current.setNext(n);
        size++; // adds the last value back to the end
        i = size;
        //this.add(x); //add the last value back to the end
      }
      i ++;
      current = current.next();
    }
  }

  public Integer remove(int index) {
    Node current = start;
    int i = 0;
    if (index == 0) {
      Integer n = start.getData();
      start = current.next();
      size--;
      return n;
    }
    while (i < size) {
      //System.out.println(this.toString());
      if (i == index - 1) {
        Node n = current.next();
        Integer old = n.getData();
        current.setNext(n.next());
        n.next().setPrev(current);
        size --; //removes last value so its not there twice
        i = size;
        return old;
      }
      i ++;
      current = current.next();
    }
    throw new IndexOutOfBoundsException("Index cannot be negative or is greater than the size");
  }

  public boolean remove(Integer value) {
    Node current = start;
      int i = 0;
      while (i < size) {
        if (current.getData().equals(value)) {
          //System.out.println("works");
          this.remove(i);
          return true;
        }
        i ++;
        current = current.next();
    }
    return false;
  }
}
