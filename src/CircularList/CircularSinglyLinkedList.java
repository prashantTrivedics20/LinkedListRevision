package CircularList;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    Node last;
    int length;
    class Node
    {
        Node next;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }
    public  CircularSinglyLinkedList()
    {
        last=null;
        length=0;
    }
    public int length()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return last==null;
    }
    public void createCircularLinkedList()
    {
        Node first=new Node(1);
        Node Second=new Node(5);
        Node Third=new Node(10);
        Node Forth=new Node(15);
        first.next=Second;
        Second.next=Third;
        Third.next=Forth;
        Forth.next=first;
        last=Forth;

    }
    // insertFirst In CircularSinglyLinkedList
    public void insertFirst(int data)
    {
        Node temp=new Node(data);
        if(last==null)
        {
            last=temp;
        }
        else
        {
            temp.next=last.next;
        }
        last.next=temp;

    }
    // insert at the end
    public void insertLast(int data)
    {
        Node temp=new Node(data);
        if(last==null)
        {
            last=temp;
            last.next=last;
        }
        else
        {
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
    }
    // remove first of the circularLinkedList
    public void removeFirst()
    {

        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node temp=last.next;
        if(last==last.next)
        {
            last=null;
        }
        else
        {
            last.next=temp.next;
        }
        temp.next=null;
    }
    // remove at Last
    public void removeLast()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        Node temp=last.next;
        if(last==last.next)
        {
            last=null;
        }
        while (temp.next!=last)
        {
            temp=temp.next;
        }
        temp.next=last.next;
        last=temp;

    }

    // Traversal of the Circular Singly Linked List
    public void Traversal()
    {
        if(last==null)
        {
            return;
        }
        Node first=last.next;
        while(first!=last)
        {
            System.out.print(first.data+" ");
            first=first.next;
        }
        System.out.print(first.data+" ");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList obj=new CircularSinglyLinkedList();
        //obj.createCircularLinkedList();
        obj.insertFirst(11);
        obj.insertFirst(12);
        //obj.insertFirst(13);
        //obj.insertLast(14);
        //obj.removeFirst();
        obj.removeLast();
        obj.Traversal();


    }
}
