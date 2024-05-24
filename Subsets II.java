/*
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10



Intuition
The problem requires generating all possible subsets of a given array, including handling duplicates.
This can be done using backtracking, where at each step we decide whether to include a particular element in the current subset or not. Sorting the array beforehand helps in easily skipping over duplicates.

Approach
Sort the Array: Sorting helps in easily identifying duplicates.
Backtracking: Use a backtracking function to generate all subsets. At each step, decide whether to include the current element in the subset or not.
Skip Duplicates: To avoid generating duplicate subsets, if the current element is the same as the previous element and the previous element was not included in the subset, skip the current element.
Complexity
Time complexity:
O(2^n), where n is the number of elements in the array. This is because in the worst case, we generate all possible subsets.
Space complexity:
𝑂(𝑛), which is the space used by the recursion stack and the temporary subset list.
*/

class Solution
{
    List<List<Integer>> finalList;
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        finalList = new ArrayList<>();
        Arrays.sort(nums);
        makeSubsets(nums,0, new ArrayList<>());
        return finalList;        
    }
    public void makeSubsets(int nums[], int i, List<Integer> list)
    {
        if(i >= nums.length)
        {
            if(!finalList.contains(list))
                finalList.add(new ArrayList<>(list));
        }
        else
        {
            list.add(nums[i]);
            makeSubsets(nums, i+1, list);
            list.remove(list.size()-1);
            makeSubsets(nums, i+1, list);
        }
    }
}
