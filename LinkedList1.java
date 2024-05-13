package A4;

import java.util.Scanner;


class Node1{
    protected int regd_no;
    protected float mark;
    protected Node1 next;
}

public class LinkedList1 {
    public static Node1 create(Node1 start){
        Scanner sc = new Scanner(System.in);
        Node1 temp = new Node1();
        System.out.println("Enter Registration No. : ");
        int regd_no = sc.nextInt();
        System.out.println("Enter Mark: ");
        float mark = sc.nextFloat();

        temp.next = null;
        start = temp;

        System.out.println("Do you want to create more than one node(1/0): ");
        int ch = sc.nextInt();

        while(ch==1){
            Node1 newnode = new Node1();
            System.out.println("Enter Registration No. : ");
            newnode.regd_no = sc.nextInt();
            System.out.println("Enter Mark: ");
            newnode.mark = sc.nextFloat();

            newnode.next = null;
            temp.next = newnode;
            temp = newnode;

            System.out.println("Do you want to create more than one node(1/0): ");
            ch = sc.nextInt();
        }
        return start;
    }

    public static void display(Node1 start){
        Node1 temp = start;

        while(temp!=null) {
            System.out.println("Registration No. : "+temp.regd_no);
            System.out.println("Mark: "+temp.mark);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node1 start = null;

        while(true){
            System.out.println("****Menu****");
            System.out.println("0: Exit");
            System.out.println("1: Creation");
            System.out.println("2: Display");

            int choice;
            System.out.println("Enter the choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    start = create(start);
                    break;
                case 2:
                    display(start);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}