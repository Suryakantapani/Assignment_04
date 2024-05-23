 import java.util.Scanner;
class Node {
    protected int regd_no;
    protected float mark;
    protected Node next;

public Node(int regd_no, float mark) {
        this.regd_no = regd_no;
        this.mark = mark;
        this.next = null;
 }}
class LinkedList {
    static Node start;
    static Scanner sc = new Scanner(System.in);
    public static Node create() {
        System.out.print("Enter registration number: ");
        int regd_no = sc.nextInt();
        System.out.print("Enter mark: ");
        float mark = sc.nextFloat();
        return new Node(regd_no, mark);
    }
    public static void display(Node start) {
        Node temp = start;
        while (temp != null) {
            System.out.print("Registration Number: " + temp.regd_no + ", Mark: " + temp.mark+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    //a) insertion
    //i. At begining
    public static Node InsBeg(Node start) {
        Node newNode = create();
        newNode.next = start;
        start = newNode;
        return start;
    }
//ii.At end  
    public static Node InsEnd(Node start) {
        Node newNode = create();
        if (start == null) {
            start = newNode;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return start;
    }
//At any index
    public static Node InsAny(Node start) {
        Node newNode = create();
        System.out.print("Enter position: ");
        int position = sc.nextInt();
        if (position == 1) {
            newNode.next = start;
            start = newNode;
        } else {
            Node temp = start;
             while(newNode.next!=null)
                    temp = temp.next;
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("The previous node is null.");
            }
        }
        return start;
    }
//   deletion  
//i. At beginning  
    public static Node DelBeg(Node start) {
        if (start == null) {
            System.out.println("The list is empty.");
        } else {
            start = start.next;
        }
        return start;
    }
//ii. From the end of the list
    public static Node DelEnd(Node start) {
        if (start == null) {
            System.out.println("The list is empty.");
        } else if (start.next == null) {
            start = null;
        } else {
            Node temp = start;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return start;
    }
//iii.From any position in the list
public static Node DelAny(Node start) {
 if (start == null) 
    System.out.println("The list is empty.");
 else {
    System.out.print("Enter position: ");
    int position = sc.nextInt();
 if (position == 1) {
    start = start.next;
     } 
 else {
    Node temp = start;
    while(temp.next!=null){
     temp = temp.next;
        }
 if (temp != null && temp.next != null) 
     temp.next = temp.next.next;
                
 else 
    System.out.println("The position does not exist.");
  
      }  }
        return start;
    }
//iv.Deleting a node based on student regd_no. If the specified node is not present
 
    public static Node DelRegdNo(Node start) {
        if (start == null) {
            System.out.println("The list is empty.");
            return start;
        }
        System.out.print("Enter registration number to delete: ");
        int regd_no = sc.nextInt();
        // If the node to be deleted is the first node
        if (start.regd_no == regd_no) {
            start = start.next;
            System.out.println("Node deleted successfully.");
            return start;
        }

        // If the node to be deleted is in the middle or last
        Node temp = start;
        while (temp.next != null && temp.next.regd_no != regd_no) {
            temp = temp.next;
        }

        // If the node to be deleted was found
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Node deleted successfully.");
        } else {
            System.out.println("Student with registration number " + regd_no + " not found.");
        }

        return start;
    }

//c) Search a node based on student regd_no and update the mark of the student.
    public static void search(Node start) {
        if (start == null) {
            System.out.println("The list is empty.");
            return;
        }
 System.out.print("Enter registration number to search: ");
        int regd_no = sc.nextInt();
        Node temp = start;
  while (temp != null) {
     if (temp.regd_no == regd_no) {
       System.out.print("Enter new mark: ");
        float new_mark = sc.nextFloat();
        temp.mark = new_mark;
       System.out.println("Mark updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with registration number " + regd_no + " not found.");
    }
//d) Sort the nodes of the linked list according to the mark secured by the student from
 
    public static void sort(Node start) {
        if (start == null || start.next == null) {
            return;
        }
        
       for (Node i = start; i.next != null; i = i.next) {
         for (Node j = i.next; j != null; j = j.next) {
                   if (i.mark < j.mark) {
                    float tempMark = i.mark;
                    int tempRegdNo = i.regd_no;
                    i.mark = j.mark;
                    i.regd_no = j.regd_no;
                    j.mark = tempMark;
                    j.regd_no = tempRegdNo;
                }
            }
        }
    }
//e) Count the number of nodes present in the linked list
    public static int count(Node start) {
        int count = 0;
        Node temp = start;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
//f)Reverse the linked list
    public static Node reverse(Node start) {
        Node prev = null;
        Node current = start;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start = prev;
        return start;
    }


    public static void main(String[] args) {
        int choice = 0;
        while (choice != 13) {
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at any position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from any position");
            System.out.println("7. Delete a node based on student registration no");
            System.out.println("8. Search and update mark");
            System.out.println("9. Sort the nodes(according to higher to lower mark)");
            System.out.println("10. Count number of Nodes");
            System.out.println("11. Reverse the LinkedList");
            System.out.println("12. Display list");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

             switch (choice) {
                case 1:
                    start = InsBeg(start);
                    break;
                case 2:
                    start = InsEnd(start);
                    break;
                case 3:
                    start = InsAny(start);
                    break;
                case 4:
                    start = DelBeg(start);
                    break;
                case 5:
                    start = DelEnd(start);
                    break;
                case 6:
                    start = DelAny(start);
                    break;
                case 7:
                    start = DelRegdNo(start);
                    break;
                case 8:
                    search(start);
                    break;
                case 9:
                    sort(start);
                    break;
                case 10:
                    System.out.println("The number of nodes: "+count(start));
                    break;
                case 11:
                    start = reverse(start);
                    System.out.println("List after reversing:");
                    display(start);
                    break;
                case 12:
                    display(start);
                    break;
                case 13:
                    System.out.println("Exiting...");
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        
    }
}
