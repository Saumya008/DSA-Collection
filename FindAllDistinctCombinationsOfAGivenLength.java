import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
class Main
{
    public static void findCombinations(int[] A, int n, int k,
                                        Set<List<Integer>> subarrays,
                                        List<Integer> out)
    {
        // invalid input
        if (A.length == 0 || k > n) {
            return;
        }
 
        // base case: combination size is `k`
        if (k == 0) {
            subarrays.add(new ArrayList<>(out));
            return;
        }
 
        // start from the next index till the first index
        for (int i = n - 1; i >= 0; i--)
        {
            // add current element `A[i]` to the output and recur for next index
            // `i-1` with one less element `k-1`
            out.add(0, A[i]);
            findCombinations(A, i, k - 1, subarrays, out);
            out.remove(0);        // backtrack
        }
    }
 
    public static Set<List<Integer>> findCombinations(int[] A, int k)
    {
        Set<List<Integer>> subarrays = new HashSet<>();
        findCombinations(A, A.length, k, subarrays, new ArrayList<>());
        return subarrays;
    }
 
    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3 };
        int k = 2;
 
        // process elements from right to left
        System.out.println(findCombinations(A, k));
    }
}
