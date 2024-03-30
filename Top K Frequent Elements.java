/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 
*/

class Solution
{
    public int[] topKFrequent(int[] nums, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int key : map.keySet())
        {
            int frequency = map.get(key);
            if(bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int res[] = new int[k];
        int count = 0;

        for(int i=bucket.length-1; i>0 && count <k; --i)
        {
            if(bucket[i] != null)
            {
                for( Integer in : bucket[i])
                {
                    res[count++] = in;
                }
            }
        }

        return res;     
    }
}
