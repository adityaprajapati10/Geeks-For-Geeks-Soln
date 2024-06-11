//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverse(String str)
    {
        //complete the function here
        char[] arr = str.toCharArray();
        int i = 0 ;
        int j = arr.length-1;
        
        while(i < j){
            if(Character.isLetter(arr[i]) && Character.isLetter(arr[j]))
            {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if(!Character.isLetter(arr[i])){
                i++;
            }
            if(!Character.isLetter(arr[j])){
                j--;
            }
        }
        return new String(arr);
    }
}