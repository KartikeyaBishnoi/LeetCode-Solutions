/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

*/

class Solution
{
    List<List<Integer>> finalList;
    public List<List<Integer>> subsets(int[] nums)
    {
        finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        makeSubset(nums, 0, list);
        return finalList; 


    }
    public void makeSubset(int nums[], int i, List<Integer> list)
    {
        if(i >= nums.length)
        {
            finalList.add(new ArrayList<>(list));
        }          
        else
        {
            list.add(nums[i]);            
            makeSubset(nums, i+1, list);
            list.remove(list.size()-1);
            makeSubset(nums, i+1, list);
        }
    }
}
