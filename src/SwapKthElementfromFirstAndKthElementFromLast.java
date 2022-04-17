import Node.Node;

import java.util.Scanner;

public class SwapKthElementfromFirstAndKthElementFromLast {
    Node head;
    int size;
    SwapKthElementfromFirstAndKthElementFromLast()
    {
        head=null;
        this.size=0;
    }
  public Node SwapKth(Node head,int k)// swap bitween kth element from beginning and kth element from end
    {
        Node temp=head;
        int i=1;
        while(i<k)
        {
            temp=temp.next;
            i++;
        }
        Node curr=temp;
        i=1;
       Node  temp1=head;
        while(i<size-k+1)
        {
            temp1=temp1.next;
            i++;
        }
        Node curr1=temp1;
        int t=curr.data;
        curr.data=curr1.data;
        curr1.data=t;
        return head;
    }
    // swap
//    public void swap(int a1 ,int a2)
//    {
//        int  temp=a1;
//        a1=a2;
//        a2=temp;
//    }
    // another approach
    public Node  swapkthSecondApproach(Node head,int k)
    {
        Node ptr2=head,temp=head,ptr1=null;
        int i=1;
        while (i<k)
        {
          temp=temp.next;
          i++;
        }
        ptr1=temp;// kth node from the start
        temp=temp.next;
        while(temp!=null)
        {
            temp=temp.next;
            ptr2=ptr2.next;
        }
        int t=ptr1.data;
        ptr1.data=ptr2.data;
        ptr2.data=t;
        return head;
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
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        SwapKthElementfromFirstAndKthElementFromLast obj=new SwapKthElementfromFirstAndKthElementFromLast();
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        for (int i = 0; i <arr.length ; i++) {
            obj.insert(arr[i]);
        }
        //Node res= obj.SwapKth(obj.head,2);
        Node res=obj.swapkthSecondApproach(obj.head,2);
        while(res!=null)
        {
            System.out.print(res.data+"->");
            res=res.next;
        }
        System.out.println("NULL");


    }

}
