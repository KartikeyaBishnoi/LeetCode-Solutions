/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

*/
// Solution 1 :
class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        int longestSubstring = 0;
        int currentSubstring = 0;
        Set<Character> set = new HashSet<>();
        int start = 0;


        for(int i=0; i<s.length(); ++i)
        {
            if(set.contains(s.charAt(i)))
            {
                set.clear();
                if(currentSubstring > longestSubstring)
                    longestSubstring = currentSubstring;
                currentSubstring = 0;
                i = start +1;
                start = i;
            }
            set.add(s.charAt(i));
            currentSubstring++;
        }
        if(currentSubstring > longestSubstring)
            longestSubstring = currentSubstring;
        return longestSubstring;       
    }
}




