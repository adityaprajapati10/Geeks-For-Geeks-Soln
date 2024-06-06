//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean check(int[] hand, int groupSize , int i){
        int next = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        while(i < hand.length && count < groupSize){
            if(next == hand[i]){
                next = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if(count == groupSize) return true;
        return false;
    }
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        int i = 0;
        for(; i<hand.length ; i++){
            if(hand[i] >= 0){
                if(!check(hand , groupSize , i))
                    return false;
            }
        }
        return true;
    }
}
