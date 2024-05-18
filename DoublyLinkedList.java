package A4.Linked_List;

import java.util.Scanner;

class Node {
    protected int regd_no;
    protected float mark;
    protected Node next;
    protected Node prev; // New field for the previous node

    public Node(int regd_no, float mark) {
        this.regd_no = regd_no;
        this.mark = mark;
        this.next = null;
        this.prev = null; // Initialize the previous node as null
    }
}

public class DoublyLinkedList {
    static Node start;
    static Node end;
    static Scanner sc = new Scanner(System.in);

    public static Node create(Node start,Node end) {
        System.out.print("Enter registration number: ");
        int regd_no = sc.nextInt();
        System.out.print("Enter mark: ");
        float mark = sc.nextFloat();
        return new Node(regd_no, mark);
    }

    // Displaying all the nodes in the list
    public static void display(Node start,Node end) {
        Node temp = start;
        while (temp != null) {
            System.out.print("Registration Number: " + temp.regd_no + ", Mark: " + temp.mark+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // The insertion operation
    // At the beginning of the list

    public static Node InsBeg(Node start,Node end) {
        Node newnode = create(start, end);
        if (start == null) {
            start=end=newnode;
        } else {
            newnode.next = start;
            newnode.prev = null;
            start.prev = newnode;
            start = newnode;

        }
        return start;
    }
    //Insert at End
    public static Node InsEnd(Node start,Node end){
        Node newnode = create(start,end);
        if(start==null){
           start=end=newnode;
        }else {
            end.next = newnode;
            newnode.prev = end;
            newnode.next = null;
            end = newnode;
        }
        return end;
    }


    // Insert at any Position
    public static Node InsAny(Node start, Node end) {
        Node newNode = create(start,end);
        System.out.print("Enter position: ");
        int position = sc.nextInt();
        if (position == 1) {
            newNode.next = start;
            if (start != null) {
                start.prev = newNode;
            }
            start = newNode;
            if (end == null) {
                end = start;
            }
        } else {
            Node temp = start;
            for (int i = 1; i < position - 1; i++) {
                if (temp != null) {
                    temp = temp.next;
                }
            }
            if (temp != null) {
                newNode.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                }
                temp.next = newNode;
                newNode.prev = temp;
                if (newNode.next == null) {
                    end = newNode;
                }
            } else {
                System.out.println("The previous node is null.");
            }
        }
        return start;
    }

    // The deletion operation
    // From the beginning of the list
    public static Node DelBeg(Node start, Node end) {
        if (start == null) {
            System.out.println("The list is empty.");
        } else {
            start = start.next;
            if (start != null) {
                start.prev = null; // Set the previous node of the start node as null
            } else {
                end = null; // If the list is now empty, set the end as null
            }
        }
        return start;
    }

    // From the end of the list
    public static Node DelEnd(Node start, Node end) {
        if (start == null) {
            System.out.println("The list is empty.");
        } else if (start.next == null) {
            start = null;
            end = null;
        } else {
            Node temp = start;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            end = temp;
        }
        return start;
    }

    // From any position in the list
    public static Node DelAny(Node start, Node end) {
        if (start == null) {
            System.out.println("The list is empty.");
        } else {
            System.out.print("Enter position: ");
            int position = sc.nextInt();
            if (position == 1) {
                start = start.next;
                if (start != null) {
                    start.prev = null; // Set the previous node of the start node as null
                } else {
                    end = null; // If the list is now empty, set the end as null
                }
            } else {
                Node temp = start;
                for (int i = 1; i < position - 1; i++) {
                    if (temp != null) {
                        temp = temp.next;
                    }
                }
                if (temp != null && temp.next != null) {
                    temp.next = temp.next.next;
                    if (temp.next != null) {
                        temp.next.prev = temp; // Set the previous node of the next node as temp
                    } else {
                        end = temp; // If the last node was deleted, set the end as temp
                    }
                } else {
                    System.out.println("The position does not exist.");
                }
            }
        }
        return start;
    }


    // Search a node based on student regd_no and update the mark of the student
    public static void search(Node start,Node end) {
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



    public static void main(String[] args) {
        int choice = 0;
        while (choice != 9) {
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at any position");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete from end");
            System.out.println("6. Delete from any position");
            System.out.println("7. Search and update mark");
            System.out.println("8. Display list");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    start = InsBeg(start,end);
                    if(end==null){
                        end=start;
                    }
                    break;
                case 2:
                    end = InsEnd(start,end);
                    if(start==null){
                        start=end;
                    }
                    break;
                case 3:
                    start = InsAny(start,end);
                    break;
                case 4:
                    start = DelBeg(start,end);
                    break;
                case 5:
                    start = DelEnd(start,end);
                    break;
                case 6:
                    start = DelAny(start,end);
                    break;
                case 7:
                    search(start,end);
                    break;
                case 8:
                    display(start,end);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
        sc.close();
    }
}

