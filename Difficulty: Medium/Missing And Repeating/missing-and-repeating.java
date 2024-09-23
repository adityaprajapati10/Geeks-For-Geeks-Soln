//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        long sum_n = (long) n * (n + 1) / 2; // Expected sum of first n natural numbers
        long sum_n2 = (long) n * (n + 1) * (2 * n + 1) / 6; // Expected sum of squares
        
        long sum_actual = 0;
        long sum_actual2 = 0;
        
        for (int num : arr) {
            sum_actual += num; // Actual sum
            sum_actual2 += (long) num * num; // Actual sum of squares
        }
        
        // Let x be the missing number, and y be the repeating number
        long x_minus_y = sum_n - sum_actual; // x - y
        long x2_minus_y2 = sum_n2 - sum_actual2; // x^2 - y^2 = (x - y)(x + y)
        
        // Now we can solve for x + y
        long x_plus_y = x2_minus_y2 / x_minus_y;
        
        // Now we have two equations:
        // 1. x - y = x_minus_y
        // 2. x + y = x_plus_y
        
        // Solving the equations:
        int x = (int) ((x_minus_y + x_plus_y) / 2);
        int y = (int) (x_plus_y - x);
        
        return new int[] {y, x}; // Return y (duplicate), x (missing)
    }
}