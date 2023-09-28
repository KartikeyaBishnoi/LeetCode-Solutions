/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]
*/
class Solution
{
    public int[] sortArrayByParity(int[] nums)
    {
        int len = nums.length;
        if(len == 1)
            return nums;

        int sorted[] = new int[len];
        int even = 0;
        int odd = len-1;
        for(int i=0; i<len; ++i)
        {
            if(nums[i] %2 == 0)
                sorted[even++] = nums[i];
            else
                sorted[odd--] = nums[i];
        }
        return sorted;
        
    }
}
