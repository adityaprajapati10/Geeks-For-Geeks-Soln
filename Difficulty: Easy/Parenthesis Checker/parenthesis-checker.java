//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        // code here
        char [] ch = s.toCharArray();
        Stack<Character> stk = new Stack<>();

        for(char ele : ch){

            if(ele == '(' || ele == '[' || ele == '{'){
                stk.push(ele);
                continue ; 
            }

            else if (stk.empty()){
                return false ;
            }

            char top = stk.pop();
            if(top == '(' && ele != ')' ){
                return false;
            }

            else if(top == '[' && ele != ']' ){
                return false;
            } 

            else if(top == '{' && ele != '}' ){
                return false;
            }
        }

        return(stk.empty() == true);
    }
}
