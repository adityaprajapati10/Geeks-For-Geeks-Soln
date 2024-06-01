//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for(char c : S.toCharArray()){
            if(Character.isDigit(c))
                st.push(c-'0');
            else{
                int n1 = st.pop();
                int n2 = st.pop();
                
                switch(c){
                    case '+':
                        st.push(n2 + n1);
                        continue;
                    case '-':
                        st.push(n2 - n1);
                        continue;
                    case '*':
                        st.push(n2 * n1);
                        continue;
                    case '/':
                        st.push(n2 / n1);
                        continue;
                }
            }
        }
        return st.pop();
    }
}