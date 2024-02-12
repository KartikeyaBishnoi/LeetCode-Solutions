/*Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

##################################################################################3

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

###################################################################################

Solution:
*/
import java.util.*;
class Solution
{
    public int majorityElement(int[] nums)
    {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<n; ++i)
        {
            int value = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i], value );            
        }
        int max = (Collections.max(map.values()));
        if(max>n/2)
        {
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
            {  
                if (entry.getValue()==max)
                {
                    return entry.getKey();
                }
            }
        }
     return 0;   
    }
}
