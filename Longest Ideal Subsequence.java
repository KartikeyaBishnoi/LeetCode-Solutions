/*
You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1.

 

Example 1:

Input: s = "acfgbd", k = 2
Output: 4
Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
Example 2:

Input: s = "abcd", k = 3
Output: 4
Explanation: The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
 

Intuition
The problem is about finding the longest ideal string where the difference between any two characters in the string is at most k. 
The intuition behind the solution is to use dynamic programming to keep track of the longest ideal string that can be formed with each character.

Approach
The approach is to iterate over the string and for each character, update the dynamic programming array dp which stores the longest ideal string that can be formed with each character.
For each character, we check the k characters before and after it in the alphabet and update the dp value for the current character based on these values. 
The answer is the maximum value in the dp array.

Complexity
Time complexity:
The time complexity is O(n⋅k)
where n is the length of the string and k is the given maximum difference between characters. 
This is because for each character in the string, we are checking k characters before and after it in the alphabet.
Space complexity:
The space complexity is O(1)
as we are using a constant amount of space to store the dp array and some variables.
Code

*/

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans=1;
        for(int i=0;i<s.length();++i)
        {
            int element = s.charAt(i) - 'a';
            for(int j=element; j>=0 && j>=element-k;j--)
            {
                dp[element] = Math.max(dp[element],dp[j]+1);
            }
            for(int j=element+1;j<26 && j<=element+k;j++){
                dp[element] = Math.max(dp[element],dp[j]+1);
            }
            ans = Math.max(ans,dp[element]);
        }
        return ans;
    }
}
