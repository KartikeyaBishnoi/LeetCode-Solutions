/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

*/

class Solution
{
    public int longestConsecutive(int[] nums)
    {
        int longestLength = 0;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int number : nums)
        {
            map.put(number,false);
        }

        for(int num : nums)
        {
            if(map.get(num) == true)
                continue;

            int currLength = 1;

            int nextNum = num+1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false)
            {
                currLength++;
                map.put(nextNum,true);
                nextNum++;
            }

            int prevNum = num-1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false)
            {
                currLength++;
                map.put(prevNum,true);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currLength);
        }
        return longestLength;


        
    }
}
