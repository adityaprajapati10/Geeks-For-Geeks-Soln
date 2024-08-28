//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // Frequency map to store frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // List of unique elements to be sorted
        List<Integer> uniqueElements = new ArrayList<>(freqMap.keySet());

        // Sort the list by frequency (desc), then by element value (asc)
        Collections.sort(uniqueElements, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqCompare = freqMap.get(b).compareTo(freqMap.get(a));
                if (freqCompare == 0) {
                    return a.compareTo(b);  // If frequencies are the same, sort by element value
                } else {
                    return freqCompare;  // Otherwise, sort by frequency
                }
            }
        });

        // Construct the result list based on sorted order
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : uniqueElements) {
            int frequency = freqMap.get(num);
            for (int i = 0; i < frequency; i++) {
                result.add(num);
            }
        }

        return result;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends