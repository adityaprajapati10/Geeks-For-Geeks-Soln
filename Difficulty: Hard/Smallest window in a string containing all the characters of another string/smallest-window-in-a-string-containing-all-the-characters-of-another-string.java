//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static String smallestWindow(String s, String p)
    {
        int i = 0,j = 0,ans = Integer.MAX_VALUE,st = -1,e = -1;
        int dest[] = new int[26];
        int curr[] = new int[26];
        for(char c:p.toCharArray()) dest[c-'a']++;
        while(j<s.length()){
            curr[s.charAt(j++)-'a']++;
            while(check(dest,curr) && i<j){
                if(ans>(j-i+1)){
                    ans = j-i+1;
                    st = i;
                    e = j;
                }
                curr[s.charAt(i++)-'a']--;
            }
        }
        return st==-1?"-1":s.substring(st,e);
    }
    static boolean check(int d[],int c[]){
        for(int i=0;i<26;i++) if(d[i]!=0 && d[i]>c[i]) return false;
        return true;
    }
}