//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long low = 0 , high = n/2 , result = -1 ;
        if(n == 1){
            return 1 ;
        }
        while(low <= high){
            long mid = low + (high - low)/2;
            long val = mid * mid ;

            if(val == n){
                return mid;
            }

            else if (val < n){
                result = mid ;
                low = mid +1 ;
            }

            else {
                high = mid -1 ;
            }
        }
        return result ;
    }
}
