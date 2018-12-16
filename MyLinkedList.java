

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
      while (current != end) {
        if (i == index) {
          return current.getData();
        }
        i ++;
        current = current.next();
      }
      return 0; //return 0 if index is out of bounds
  }

  public Integer set(int index,Integer value) {
    Node current = start;
    int i = 0;
    while (current != end) {
      if (i == index) {
        int old = current.getData();
        current.setData(value);
        return old;
      }
      i ++;
      current = current.next();
    }
    return 0;
  }

 public boolean contains(Integer value) {
   Node current = start;
   int i = 0;
   while (current != end) {
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
    while (current != end) {
      if (current.getData() == value) {
        return index;
      }
      index ++;
      current = current.next();
    }
    return -10; //returns -10 if it does not contain the integer
  }

  public void add(int index, Integer value) {
    Integer x = end.getData();
    Node current = start;
    int i = 0;
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
    while (i < size - 1) {
      //System.out.println(this.toString());
      if (i == index) {
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
    return -10;
  }

  /*public Integer remove(Integer value) {

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
          //System.out.println(list.size()); //<- Debugging
      }
      System.out.println(list);
      System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");

      /*System.out.println(list.get(3));
      System.out.println(list.get(5));
      System.out.println(list.set(3, 5));
      System.out.println(list.set(5, 3));
      System.out.println(list);*/

      //Step Six: Testing the Contains Method
      System.out.println("##############################");
      System.out.println("##Checking Containment Test:##");
      System.out.println("##############################");
      System.out.println(list.contains(999));
      System.out.println("This should print: false");
      System.out.println(list.contains(3));
      System.out.println("This should print: true");

      System.out.println("########################");
      System.out.println("##Index of Value Test:##");
      System.out.println("########################");
      System.out.println(list.indexOf(0));
      System.out.println("This should print: 0");
      System.out.println(list.indexOf(5));
      System.out.println("This should print: 5");

      System.out.println("#####################################");
      System.out.println("##Adding Values in the Middle Test:##");
      System.out.println("#####################################");
      list.add(5, 999);
      list.add(15, 999);
      System.out.println(list);
      System.out.println("This should print: \"[0, 1, 2, 3, 4, 999, 5, 6, 7, 8, 9]\"");

      //Step Four: Removing a value from the list by index
      System.out.println("##########################");
      System.out.println("##Removing a Value Test:##");
      System.out.println("##########################");
      list.remove(4);
      System.out.println(list);
      System.out.println("This should print: \"[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\"");
    }
}
