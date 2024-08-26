//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int i = 0 , j = 0 , match = 0 , star = -1;
        while(i<str.length()){
            if(j<pattern.length() && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) =='?' )){
                i++;
                j++;
            }
            else if(j<pattern.length() && pattern.charAt(j) == '*'){
                star = j;
                match = i;
                j++;
            }
            else if(star != -1){
                j = star+1;
                match++;
                i = match;
            }
            else{
                return 0;
            }
        }
        while (j < pattern.length() && pattern.charAt(j) == '*') {
            j++;
        }
        if(j == pattern.length()){
            return 1;
        }
        return 0;
    }
}
