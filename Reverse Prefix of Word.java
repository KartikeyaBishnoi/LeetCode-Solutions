/*
Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
Return the resulting string.

 

Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
 
Intuition
The intuition behind this problem is to iterate over the string until we find the character ch. While iterating, we keep adding each character at the beginning of a new string part. This way, we are effectively reversing the segment of the string from index 0 to the current index.

Approach
The approach taken in the provided code is straightforward:

Iterate over the string word.
For each character c in word, check if it is equal to ch.
If c is equal to ch, add c to the beginning of part, append the rest of word to part, and return part.
If c is not equal to ch, add c to the beginning of part.
If ch is not found in word after iterating over the entire string, return word.
Complexity
Time complexity:
The time complexity is O(n),
where n is the length of the string word. This is because we are iterating over the string once.
Space complexity:
The space complexity is also O(n),
where n is the length of the string word. This is because we are creating a new string part that can be as long as word in the worst case.
Code
*/

class Solution
{
    public String reversePrefix(String word, char ch)
    {
        int len = word.length();
        String part = "";

        for(int i=0; i<len; ++i)
        {
            char c = word.charAt(i);
            if(ch == c)
            {
                part = c + part;
                part += word.substring(i+1);
                return part;
            }
            else
                part = c + part ;
        }
        return word;
        
    }
}
