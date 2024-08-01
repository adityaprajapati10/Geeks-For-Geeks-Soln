//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        if (mat[0][0] == 1) {
            StringBuilder temp = new StringBuilder();
            solve(0, 0, n, ans, temp, mat);
        }
        return ans;
    }
    static void solve(int i , int j , int n, ArrayList<String> ans , StringBuilder temp, int[][] mat){
        if(!(i >= 0 && i < n && j >= 0 && j < n )|| mat[i][j] == 0 )
            return;
        if(i == n-1 && j == n-1){
            ans.add(temp.toString());
        }
        mat[i][j] = 0;

        temp.append('D');
        solve(i + 1, j, n, ans, temp, mat);
        temp.deleteCharAt(temp.length() - 1);

        temp.append('R');
        solve(i, j + 1, n, ans, temp, mat);
        temp.deleteCharAt(temp.length() - 1);

        temp.append('U');
        solve(i - 1, j, n, ans, temp, mat);
        temp.deleteCharAt(temp.length() - 1);

        temp.append('L');
        solve(i, j - 1, n, ans, temp, mat);
        temp.deleteCharAt(temp.length() - 1);

        mat[i][j] = 1;
    }
}