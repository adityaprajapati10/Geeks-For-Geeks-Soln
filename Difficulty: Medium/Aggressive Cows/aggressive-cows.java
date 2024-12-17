//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        int start = 1, end, mid, ans=0;
        Arrays.sort(stalls);  
        end = stalls[n-1];
        while(start<=end){
            mid = start + (end - start)/2;
            int count =1, pos = stalls[0];
            for(int i=1;i<n;i++){
                if(pos + mid <=stalls[i]){
                    count++;
                    pos = stalls[i];
                }
            }
            if(count < k)
            end = mid-1;
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
}