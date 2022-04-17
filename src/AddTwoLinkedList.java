import Node.Node;

import java.util.Scanner;

public class AddTwoLinkedList {
    Node head1;
    Node  head2;
    int size1;
    int size2;
    // MergeTwoSortedLists()
    {
        this.size1=0;
        this.size2=0;
        head1=null;
        head2=null;

    }
    public void insert1(int data)
    {
        Node newNode=new Node(data);
        if(head1==null)
        {
            head1=newNode;
            size1++;

            return;
        }
        else {
            size1++;
            Node temp = head1;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void insert2(int data)
    {
        Node newNode=new Node(data);
        if(head2==null)
        {
            head2=newNode;
            size2++;

            return;
        }
        else {
            size2++;
            Node temp = head2;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public Node AddTwoLinkedLists(Node a,Node b)
    {
        Node dummy=new Node(0);
        Node tail=dummy;
        int carry=0;
        while(a!=null||b!=null) {
            int x=(a!=null)? a.data:0;
            int y=(b!=null)?b.data:0;
            int sum=carry+x+y;
            carry=sum/10;
            tail.next=new Node(sum%10);
            tail=tail.next;
            if(a!=null)
            {
                a=a.next;
            }
            if(b!=null)
            {
                b=b.next;
            }
        }
        if(carry>0)
        {
            tail.next=new Node(carry);
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        AddTwoLinkedList obj=new AddTwoLinkedList();
        Scanner readme=new Scanner(System.in);
        System.out.println("Enter the size of the first linked list");
        int n=readme.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the element");
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        System.out.println("Enter the size of the second linked list");
        int n1=readme.nextInt();
        int arr1[]=new int[n1];
        System.out.println("Enter the element");
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=readme.nextInt();
        }
        for(int i=0;i<arr.length;i++)
        {
            obj.insert1(arr[i]);
        }
        for(int i=0;i<arr1.length;i++)
        {
            obj.insert2(arr1[i]);
        }
        Node merge=obj.AddTwoLinkedLists(obj.head1,obj.head2);
        while(merge!=null)
        {
            System.out.print(merge.data+" ");
            merge=merge.next;
        }

    }

}
