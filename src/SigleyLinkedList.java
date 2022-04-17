import Node.Node;
public class SigleyLinkedList {
    Node head;
    int size;
    SigleyLinkedList()
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
    // insert at the given position
    public void insertAtGivenPosition(int data,int position)
    {
        Node newNode=new Node(data);
        Node temp=head;
        Node current=null;
        int i=1;
        while(i<position-1)
        {
            temp=temp.next;
            i++;
        }
        current=temp.next;
        temp.next=newNode;
        newNode.next=current;
    }
    //remove the node at the last in the linked list\
    public void removeLast()
    {
        Node temp=head;
        Node previous=null;
        while(temp.next!=null)
        {
            previous=temp;
            temp=temp.next;
        }
        previous.next=null;

    }
    // remove at the given position
    public void removeGivenPosition(int position)
    {
        Node temp=head;
        int i=1;
        while(i<position-1)
        {
            temp=temp.next;
            i++;

        }
        temp.next=temp.next.next;
    }
    // reverse A linkedList
    public Node reverse(Node head)
    {
        Node current=head;
        Node next=null;
        Node previous=null;
        while(current!=null)
        {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    // middle of the linkedList
    public Node middle(Node head)
    {
        Node slowptr=head;
        Node fastPtr=head;
        while(fastPtr!=null&&fastPtr.next!=null)
        {
            slowptr=slowptr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowptr;
    }
    public Node nthNode(int n)
    {
        Node temp=head;
        int i=1;
        while(i<size-n+1)
        {
            temp= temp.next;
            i++;
        }
        return temp;
    }
    // removeDuplicateFromSortedLinkedList
    public Node  removeDuplicate(Node head)
    {
        Node current=head;
        while(current!=null&&current.next!=null) {
            if (current.data == current.next.data){
                current.next=current.next.next;
        }
            else
            {
                current=current.next;
            }

        }


        return head;
    }
    //Detection A cycle of a LinkedList (basically your task is to detect weather the LinkedList consist a cycle or not
    public boolean checkCycle(Node head)
    {
        Node fastptr=head;
        Node slowptr=head;
        while(fastptr!=null&&fastptr.next!=null)
        {
            fastptr=fastptr.next.next;
            slowptr=slowptr.next;
            if(slowptr==fastptr)
            {
                return true;
            }
        }
        return false;
    }
    public Node getStartLoop(Node slowPtr)
    {
        Node temp=head;
        while(temp!=slowPtr)
        {
            temp=temp.next;
        }
        return temp;

    }
    // start of the loop in singly LinkedList
    public Node startOfTheLoop( Node head)
    {
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null&&fastPtr.next!=null)
        {
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr)
            {
                return getStartLoop(slowPtr);
            }
        }
        return null;
    }
    // Remove a loop from singly Linked List
    public void removeLoop(Node slowPtr)
    {
        Node temp=head;
        if(temp.next!=slowPtr.next)
        {
            temp=temp.next;
            slowPtr=slowPtr.next;

        }
        slowPtr.next=null;

    }
    public void removeLoopFromList(Node head)
    {
        Node fastPtr=head;
        Node slowPtr=head;
        if(fastPtr!=null&&fastPtr.next!=null)
        {
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr)
            {
                removeLoop(slowPtr);
                return;

            }
        }
    }
    // reverse a linkedList By using recursively
    public  Node reverseRecursively(Node head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node newNode=reverseRecursively(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;

    }
    // check Weather the linkedList is palindrome or not.....
    public boolean isPalindrome(Node head)
    {
        if(head==null||head.next==null)
        {
            return true;
        }
        Node middle=middle(head);
        Node SecondHalfStart=reverse(middle);
        Node firstHalfStart=head;
        while (SecondHalfStart!=null)
        {
            if(firstHalfStart.data!=SecondHalfStart.data)
            {
                return false;
            }
            firstHalfStart=firstHalfStart.next;
            SecondHalfStart=SecondHalfStart.next;
        }
        return true;
    }
    public void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        SigleyLinkedList obj=new SigleyLinkedList();
        obj.insert(1);
        obj.insert(2);
        //obj.insert(2);
        //obj.insert(1);
       obj.insert(3);
        obj.insert(4);
        obj.insert(5);
//        obj.insertAtGivenPosition(5,3);
//        obj.print();
//        obj.removeLast();
//        obj.print();
//        obj.removeGivenPosition(3);
//        obj.print();
//        Node res=obj.reverse();
//        while(res!=null)
//        {
//            System.out.print(res.data+"->");
//            res=res.next;
//        }
//        System.out.println("NULL");
       //Node res= obj.nthNode(2);
        //System.out.println(res.data);

       Node res= obj.removeDuplicate(obj.head);
//       while(res!=null)
//       {
//           System.out.print(res.data+" ");
//           res=res.next;
//       }
//       boolean checkPalindrome=obj.isPalindrome(obj.head);
//        System.out.println(checkPalindrome);
       Node reverse= obj.reverseRecursively(obj.head);
       while(reverse!=null)
       {
           System.out.print(reverse.data+" ");
           reverse=reverse.next;
       }


    }



}
