package MainMethodOfLinkedList;
import Node.Node;
import SegrageteEvenAndOddFromLinkedList.SegregateEvenAndOddFromLinkedList;
import java.util.Scanner;
public class MainMethodOfLinkedList {
    public static void main(String ars[]) {
        SegregateEvenAndOddFromLinkedList obj = new SegregateEvenAndOddFromLinkedList();
        Scanner readme = new Scanner(System.in);
        int n = readme.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            obj.insert(readme.nextInt());
        }
        Node res=obj.segregateEvenOdd();
        while(res!=null)
        {
            System.out.print(res.data+" ");
            res=res.next;
        }



    }
}
