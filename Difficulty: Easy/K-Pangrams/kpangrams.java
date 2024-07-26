//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        HashSet<Character> set = new HashSet<>();
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch==' ')
                continue;
            else
            {
                set.add(ch); 
                count++;
            }
        }
    
        if(count<26) return false;
        if(k+set.size()>=26 || set.size()==26) return true;
     return false;   
    }
}