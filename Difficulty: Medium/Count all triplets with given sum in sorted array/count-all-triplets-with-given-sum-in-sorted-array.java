//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int count =0;
        int n = arr.length;
        
        for(int i =0 ; i< n-2; i++){
            int l = i+1, h = n-1;
            while(l<h){
                int sum = arr[i] + arr[l] + arr[h];
                if(sum == target){
                    count++;
                    
                    int tempL = l + 1;
                    int tempH = h - 1;
                    
                    while(tempL < h && arr[tempL] == arr[l]){
                        count++;
                        tempL++;
                    }
                    
                    while(tempH > l && arr[tempH] == arr[h]){
                        count++;
                        tempH--;
                    }
                    
                    l++;
                    h--;
                }
                
                else if(sum < target){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        return count;
    }
}