//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        for(String s:arr){
                int i=0;
                while(i<res.size()&&!isAnagram(s,res.get(i).get(0)))
                {
                    i++;
                }
                if(i==res.size())
                {
                    res.add(new ArrayList<>());
                }
                res.get(i).add(s);
            }
            return res;
        }
    public static boolean isAnagram(String a,String b)
    {
        Map<Character,Integer> m=new HashMap<>();
        for(char c:a.toCharArray())
        {
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(char c:b.toCharArray())
        {
            if(m.containsKey(c))
                m.put(c,m.get(c)-1);
            else
                return false;
            if(m.get(c)==0) m.remove(c);
        }
        return m.size()==0;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends