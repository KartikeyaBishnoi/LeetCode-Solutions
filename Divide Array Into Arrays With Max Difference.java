/*Divide Array Into Arrays With Max Difference
You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. 
And if there are multiple answers, return any of them.

 

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.
  */

class Solution {
    public int[][] divideArray(int[] nums, int k)
    {
        int len = nums.length;
        int answer [][] = new int[len/3][3];
        Arrays.sort(nums);
        int counter = 0;

        for(int i=0; i<len/3; ++i)
        {
            if(check(nums[counter], nums[counter+1], nums[counter+2], k))
            {
                for(int j=0; j<3; ++j)
                {
                    answer[i][j] = nums[counter++];                
                }
            }
            else
            {
                return new int[0][0];
            }
        } 
        return answer;        
    }
    
    public boolean check(int a, int b, int c, int k)
    {
        if(Math.abs(a-b) <= k && Math.abs(b-c) <= k && Math.abs(c-a) <= k)
        {
            return true;
        }
        return false;
    }
}
