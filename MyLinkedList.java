

public class MyLinkedList{

  private class Node{
    private Integer data;
    private Node next,prev;

    public Node (Integer a, Node nextref, Node prevref) {
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

  private Node getNthNode(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " is out of bounds");
    }
    Node current = start;
    int i = 0;
    while (i != index) {
      i ++;
      current = current.next();
    }
    return current;
  }

  public Integer get(int index){
      return getNthNode(index).getData();
  }

  public Integer set(int index,Integer value) {
    Integer old = getNthNode(index).getData();
    getNthNode(index).setData(value);
    return old;
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
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " is out of bounds");
    }
    if (index == 0) {
      Node n = new Node (value, start, null);
      start = n;
      size ++;
    }
    if (index == size) {
      this.add(value);
    }
    if (index != 0 && index != size){
    Node newNext = getNthNode(index);
    Node newPrev = newNext.prev();
    Node addThis = new Node (value, newNext, newPrev);
    newNext.setPrev(addThis);
    newPrev.setNext(addThis);
    size ++;
  }
}

  public Integer remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index + " is out of bounds");
    }
    if (index == 0) {
      Integer old = start.getData();
      Node newStart = start.next();
      newStart.setPrev(null);
      start = newStart;
      size--;
      return old;
    }
    if (index == size - 1) {
      Integer old = end.getData();
      Node newEnd = end;
      newEnd.setNext(null);
      end = newEnd;
      size--;
      return old;
    }
    if (index != 0 && index != size - 1){
    Node current = getNthNode(index);
    Node newPrev = current.prev();
    Node newNext = current.next();
    Integer old = newPrev.getData();
    Node k = getNthNode(index - 1);
    newNext.setPrev(newPrev);
    newPrev.setNext(newNext);
    size--;
    return old;
  }
  return 0;
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
