//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    boolean carry = false;
    public void helper(Node head){
        if(head.next != null){
            helper(head.next);
            if(carry == true)head.data+=1;
            if(head.data >9){
                carry = true;
                head.data = 0;
                return;
            }
            else{
                carry = false;
                return;
            }
        }
        else{
            head.data +=1;
            if(head.data >9){
                head.data = 0;
                carry = true;
                return;
            }
            else{
                carry = false;
                return;
            }
        }
    }
    public Node addOne(Node head) {
        int flag = head.data;
        helper(head);
        if(head.data == 0 && flag == 9){
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        else return head;
    }
}
