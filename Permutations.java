/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.


Intuition
To generate all permutations of an array of integers, we can use a backtracking approach. The idea is to build permutations one element at a time, and explore all potential placements of each element.

Approach
Backtracking:

Start with an empty permutation and try to build permutations by adding each number from the array.
If the current permutation contains all elements from the input array, it is a complete permutation, so add it to the result list.
Otherwise, for each number not yet in the current permutation, add the number to the permutation, recursively attempt to complete the permutation, and then remove the number to backtrack and try the next option.
Handling Duplicates:

Use a check to ensure that a number is not added more than once in the same permutation.

Complexity
Time complexity:
O(n×n!)
There are 𝑛! permutations for an array of length 𝑛, and each permutation takes 𝑂(𝑛) time to construct.

Space complexity:
O(n!)
This is because we store all permutations, and the depth of the recursion tree is n, but the dominant factor is the number of permutations stored.

Code
*/

class Solution
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums)
    {
        // If we match the length, it is a permutation
        if (tempList.size() == nums.length) 
        {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int number : nums)
        {
            // Skip if we get same element
            if (tempList.contains(number))
                continue;

            // Add the new element
            tempList.add(number);

            // Go back to try other element
            backtrack(resultList, tempList, nums);

            // Remove the element
            tempList.remove(tempList.size() - 1);
    
        }
    }
}

        
