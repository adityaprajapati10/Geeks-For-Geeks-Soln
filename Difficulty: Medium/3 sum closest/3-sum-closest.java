//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int arr[], int N, int X)
    {
        // code here
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum1 = arr[i] + arr[j] + arr[k];
    
                result.add(sum1); 
                if (sum1 == X) {
                    return X;
                } else if (sum1 < X) {
                    j++;
                } else {
                    k--;  
                }
            }
        }

        Collections.sort(result);
        int i = 0;
        int j = result.size() - 1;
        int res = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (result.get(mid) < X) {
                i = mid + 1;
                res = result.get(mid);
            } else {
                j = mid - 1;
                res = result.get(mid);
            }
        }
        
        return res ;
    }
}