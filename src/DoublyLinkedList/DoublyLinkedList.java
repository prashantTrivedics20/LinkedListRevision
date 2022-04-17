package DoublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int length;
    DoublyLinkedList(){
        head=tail=null;
        this.length=0;
    }
    private class ListNode
    {
        private int data;
        private ListNode next;
        private ListNode previous;
        ListNode(int data)
        {
            this.data=data;
            next=previous=null;
        }
    }
    public boolean isEmpty()
    {
        return  head==null;
    }
    public int length()
    {
        return length;
    }
    // traverse the DoublyLinkedList in forword Direction
    public void forwordTraverse() {
        if(head==null)
        {
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public void BackWordTraverse() {
        if(tail==null)
        {
            return;
        }
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.previous;
        }
    }
    // insert newNode at the beginning of a linked list
    public void insertFirst(int data)
    {
        ListNode newNode=new ListNode(data);
        if(isEmpty())
        {
          tail=newNode;
        }
        else
        {
           head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
    }
    // insert the node at the end of the
    public void  insertLast(int data)
    {
        ListNode newNode=new ListNode(data);
        if(isEmpty())
        {
            head=newNode;
        }
        else
        {
            tail.next=newNode;
            newNode.previous=tail;
        }
        tail=newNode;
    }
    // removeFromFirstDoublyLinkedList
    public ListNode removeFirst()
    {

        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp=head;
        if(head==tail)
        {
            tail=null;
        }
        else
        {
            head.next.previous=null;
        }
        head=head.next;
        temp.next=null;
        return temp;


    }
    // remove at the last of the linked list



    public static void main(String[] args) {
        DoublyLinkedList obj=new DoublyLinkedList();
        obj.insertLast(5);
        obj.insertLast(6);
        obj.insertLast(7);
        obj.forwordTraverse();
        obj.BackWordTraverse();
        ListNode res=obj.removeFirst();
        System.out.println();
        System.out.println(res.data);
    }





}
