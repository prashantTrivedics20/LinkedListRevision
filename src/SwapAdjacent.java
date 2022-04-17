import Node.Node;
import java.util.Scanner;
public class SwapAdjacent {
    Node head;
    int size;
    SwapAdjacent()
    {
        head=null;
        this.size=0;
    }
    public void insert(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            size++;

            return;
        }
        else {
            size++;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public Node swapAdjacent(Node head)
    {
        Node current=head;
        Node previous=null;
        Node next=null;
        int c=0;
        while(current!=null&&c<2)
        {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
            c++;
        }
        if(next!=null) {
            head.next= swapAdjacent(next);

        }
        return previous;
    }

    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        SwapAdjacent obj=new SwapAdjacent();
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        for (int i = 0; i <arr.length ; i++) {
            obj.insert(arr[i]);
        }
      Node res= obj.swapAdjacent(obj.head);
        while(res!=null)
        {
            System.out.print(res.data+"->");
            res=res.next;
        }
        System.out.println("NULL");


    }


}
