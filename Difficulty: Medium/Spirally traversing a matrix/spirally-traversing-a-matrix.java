//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int sr = 0;
        int er = matrix.length-1;
        int sc = 0;
        int ec = matrix[0].length-1;
        
        while(sr <= er && sc <= ec){
            for(int i = sc ; i<=ec ; i++){
                list.add(matrix[sr][i]);
            }
            sr++; // es row me dubara nhi aana bhai
            
            for(int i = sr ; i <= er ; i++){
                list.add(matrix[i][ec]);
            }
            ec--; // es coln me dubara nhi aana bhai
            if(sr <= er){
                for(int i = ec ; i >= sc ; i--){
                    list.add(matrix[er][i]);
                }
                er--; // es row me dubara nhi aana bhai
            }
            if(sc <= ec){
                for(int i = er ; i >= sr ; i--){
                    list.add(matrix[i][sc]);
                }
                sc++; // es row me dubara nhi aana bhai
            }
        }
        return list;
    }
}
