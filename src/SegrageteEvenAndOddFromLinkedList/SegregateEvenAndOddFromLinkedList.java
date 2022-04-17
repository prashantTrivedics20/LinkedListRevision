package SegrageteEvenAndOddFromLinkedList;

import Node.Node;
public class SegregateEvenAndOddFromLinkedList {
    Node head;
    Node tail;
    int size;
    public SegregateEvenAndOddFromLinkedList()
    {
        head=tail=null;
    }
    public void insert(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            size++;
        }
        else
        {
            tail.next=newNode;
            tail=newNode;
            size++;
        }
    }
    public Node  segregateEvenOdd()
    {

        Node evenStart=null;
        Node evenEnd=null;
        Node oddStart=null;
        Node oddEnd=null;
        Node current=head;
        while(current!=null)
        {
            if(current.data%2==0) {
                // even segregation
                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = current;
                }
            }
            // OddSegregation
            if(current.data%2==1) {
                // even segregation
                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = current;
                }
            }
            current=current.next;
        }
        // now
        if(evenStart==null||oddStart==null)
        {
            return null;

        }
        evenEnd.next=oddStart;
        oddEnd.next=null;
        head=evenStart;
        return head;
    }
}
