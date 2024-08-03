//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
         int n = mat.length;
        int count = 0;
        int celeb = -1;
        int in = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j]==1)
                    count++;
                if(j==n-1 && count==0)
                {
                        celeb = i;
                        in++;
                }
                else if(j==n-1 && count>0){
                    count=0;
                }
            }
        }
        int celebcount=0;
        if(in==1 && celeb>-1)
        {
           for(int i=0; i<n; i++)
        {
            if(i!=celeb && mat[i][celeb]==1)  celebcount++;
        } 
        }
        
        
        return (in==1 && celebcount==n-1)?celeb:-1;
    }
}