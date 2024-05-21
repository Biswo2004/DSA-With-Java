package Queue;
import java.util.Scanner;
public class QueueDemo1 {
    static Scanner sc = new Scanner(System.in);
    public static final int MAX=5;
    public static int front=-1;
    public static int rear=-1;

    public static boolean is_full(){
        return rear==MAX-1;
    }

    public static boolean is_empty(){
        return rear==-1;
    }

    public static void insert(int queue[]){
       if(is_full()){
           System.out.println("The queue is full.");
       }
       else{
           System.out.println("Enter the Element: ");
           int data = sc.nextInt();
           rear = rear + 1;
           queue[rear] = data;
           System.out.println("Data inserted: "+data);
           if(front==-1){
               front = front+1;
           }
       }
    }


    public static void delete(int queue[]){
        if(is_empty()){
            System.out.println("The queue is empty.");
        }
        else{
            int del = queue[front];
            front = front + 1;
            System.out.println("Data deleted: "+del);
        }
    }


    public static void display(int queue[]){
        if(front==-1 || front>rear){
            System.out.println("Queue is Empty.");
        }
        else{
            System.out.println("The Queue is: ");
            for(int i=front;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int queue[]=new int[MAX];
        while(true)
        {
            System.out.println("***MENU***");
            System.out.println("0: Exit");
            System.out.println("1: Insert");
            System.out.println("2: Delete");
            System.out.println("3: Display");
            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insert(queue);
                    break;
                case 2:
                    delete(queue);
                    break;
                case 3:
                    display(queue);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
