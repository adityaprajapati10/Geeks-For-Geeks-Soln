//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/*Node is defined as
class Node
{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class Solution {
    long e = 1000000007;
    public long multiplyTwoLists(Node first, Node second) {
     
        long sum1 = 0, sum2 = 0; // two variables to get the numbers
        
        while(first != null) // running the while loop until we get null
        {
            sum1 = ((sum1 * 10) + first.data) % e; //getting the first number
            first = first.next; // important to keep changing the pointer
        }
        
        while(second != null) // running the while loop until we get null
        {
            sum2 = ((sum2 * 10) + second.data) % e; //getting the second number
            second = second.next; // important to keep changing the pointer
        }
        
        return (sum1 * sum2 ) % e ;
    }
}

//{ Driver Code Starts.

public class GFG {
    public static Node newNode(int data) { return new Node(data); }

    public static void push(Node[] head_ref, int new_data) {
        Node new_Node = newNode(new_data);
        new_Node.next = head_ref[0];
        head_ref[0] = new_Node;
    }

    public static void reverse(Node[] r) {
        Node prev = null;
        Node cur = r[0];
        Node nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        r[0] = prev;
    }

    public static void freeList(Node Node) {
        Node temp;
        while (Node != null) {
            temp = Node;
            Node = Node.next;
            // In Java, garbage collection takes care of freeing memory.
        }
    }

    public static void printList(Node Node) {
        while (Node != null) {
            System.out.print(Node.data + " ");
            Node = Node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            Node[] first = new Node[1];
            Node[] second = new Node[1];
            first[0] = null;
            second[0] = null;

            String input = sc.nextLine();
            String[] arr = input.split(" ");
            for (String s : arr) {
                push(first, Integer.parseInt(s));
            }

            String input2 = sc.nextLine();
            String[] brr = input2.split(" ");
            for (String s : brr) {
                push(second, Integer.parseInt(s));
            }

            reverse(first);
            reverse(second);

            Solution ob = new Solution();
            long res = ob.multiplyTwoLists(first[0], second[0]);
            System.out.println(res);

            // Free list is not necessary in Java
        }

        sc.close();
    }
}

// } Driver Code Ends