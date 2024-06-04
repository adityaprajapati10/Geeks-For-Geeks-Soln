//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    public static int matSearch(int matrix[][], int N, int M, int target)
    {
        // your code here
        for(int i = 0 ; i< matrix.length ; i++){
            int low = 0 , high = matrix[i].length-1;
            int mid ;
            while (low <= high){
                mid = low + ( high - low)/2 ;
                
                if(matrix[i][mid] == target){
                    return 1 ;
                }

                else if(matrix[i][mid] < target){
                    low = mid + 1 ;
                }

                else{
                    high = mid - 1;
                }
            }
        }
        return 0;
    }
}