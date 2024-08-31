//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to find three numbers such that arr[smaller[i]] < arr[i] <
    // arr[greater[i]]
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        // int ptr1 = Integer.MAX_VALUE;
        // int ptr2 = Integer.MAX_VALUE;
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int i : arr){
        //     if(i <= ptr1){
        //         ptr1 = i;
        //     }
        //     else if(i <= ptr2){
        //         ptr2 = i;
        //     }else if(i>ptr1 && i >ptr2){
        //         list.add(ptr1);
        //         list.add(ptr2);
        //         list.add(i);
        //         return list;
        //     }
        // }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = i+1 ; j<arr.length ; j++){
                if(arr[j] > arr[i]){
                    for(int k = j+1 ; k<arr.length ; k++){
                        if(arr[k] > arr[j]){
                            list.add(arr[i]);
                            list.add(arr[j]);
                            list.add(arr[k]);
                            return list;
                        }   
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}