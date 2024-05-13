//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
        int n=heights.length;
        int m=heights[0].length;
        
        int[][] dis=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)1e9;
            }
        }
        
        PriorityQueue<int[]> q=new PriorityQueue<>((x,y)->x[0]-y[0]);
        q.add(new int[]{0,0,0});
        int total=Integer.MAX_VALUE;
        
        while(q.size()>0){
        
            int eff=q.peek()[0];
            int i=q.peek()[1];
            int j=q.peek()[2];
            
            if(i==n-1&&j==m-1){
               // System.out.println(eff);
                total=Math.min(eff,total);
            }
            q.poll();
            
            if(i-1>=0){
                int ndis=Math.abs(heights[i][j]-heights[i-1][j]);
                if(ndis<dis[i-1][j]){
                    q.add(new int[]{
                        Math.max(eff,ndis),i-1,j
                    });
                    dis[i-1][j]=ndis;
                }
            }
            
            if(j-1>=0){
                int ndis=Math.abs(heights[i][j]-heights[i][j-1]);
                if(ndis<dis[i][j-1]){
                    q.add(new int[]{
                        Math.max(eff,ndis),i,j-1
                    });
                    dis[i][j-1]=ndis;
                }
            }
            
            if(i+1<n){
                int ndis=Math.abs(heights[i][j]-heights[i+1][j]);
                if(ndis<dis[i+1][j]){
                    q.add(new int[]{
                        Math.max(eff,ndis),i+1,j
                    });
                    dis[i+1][j]=ndis;
                }
            }
            if(j+1<m){
                int ndis=Math.abs(heights[i][j]-heights[i][j+1]);
                if(ndis<dis[i][j+1]){
                    q.add(new int[]{
                        Math.max(eff,ndis),i,j+1
                    });
                    dis[i][j+1]=ndis;
                }
            }
        }
        return total;
        }
}
