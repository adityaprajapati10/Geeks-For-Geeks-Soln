//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList_Intersection {
    Node head = null;
    Node tail = null;

    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            // Node temp = head;
            // while (temp.next != null)
            // temp = temp.next;

            // temp.next = node;
            tail.next = node;
            tail = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {

            LinkedList_Intersection llist1 = new LinkedList_Intersection();
            LinkedList_Intersection llist2 = new LinkedList_Intersection();
            LinkedList_Intersection llist3 = new LinkedList_Intersection();

            String str[] = read.readLine().trim().split(" ");
            int n1 = str.length;
            Node head1 = new Node(Integer.parseInt(str[0]));

            Node tail1 = head1;

            for (int i = 1; i < n1; i++) {
                int a = Integer.parseInt(str[i]);
                tail1.next = (new Node(a));
                tail1 = tail1.next;
            }

            str = read.readLine().trim().split(" ");
            Node head2 = new Node(Integer.parseInt(str[0]));
            Node tail2 = head2;
            int n2 = str.length;
            for (int i = 1; i < n2; i++) {
                int b = Integer.parseInt(str[i]);
                tail2.next = (new Node(b));
                tail2 = tail2.next;
            }

            str = read.readLine().trim().split(" ");
            int n3 = str.length;
            if (n3 > 0) {

                Node head3 = new Node(Integer.parseInt(str[0]));
                tail1.next = head3;
                tail2.next = head3;
                Node tail3 = head3;
                for (int i = 1; i < n3; i++) {
                    int c = Integer.parseInt(str[i]);
                    tail3.next = (new Node(c));
                    tail3 = tail3.next;
                }
            }
            Intersect obj = new Intersect();
            System.out.println(obj.intersectPoint(head1, head2));
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
     int intersectPoint(Node head1, Node head2) {
        // code here
        
        Node left = head1;
        Node right = head2;
        
        int left1 = 0;
        int right1 = 0;
        
        
        while(left!=null){
            
            left1++;
            
            left = left.next;
            
            
        }
        
        while(right!=null){
            right1++;
            right = right.next;
        }
        
        if(left1>right1){
            
            int diff = left1-right1;
            
            while(diff>0){
                head1 = head1.next;
                diff--;
                
            }
        }
        else {
            int diff = right1-left1;
            while(diff>0){
                head2 = head2.next;
                diff--;
            }
        }
        
        
        Node current1 = head1;
        Node current2 = head2;
        
        while(current1.next!=null && current2.next!=null){
            if(current1.next==current2.next){
                return current1.next.data;
            }
            
            current1 = current1.next;
            current2 = current2.next;
        }
        
        return -1;
    }


}
