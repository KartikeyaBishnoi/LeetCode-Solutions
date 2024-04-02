/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

*/

//Solution 1:

class Solution
{
    public boolean isIsomorphic(String s, String t)
    {
        return checkIso(s,t) && checkIso(t,s);        
    }

    public boolean checkIso(String s, String t)
    {
        if(s.length() != t.length())
            return false;

        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0; i<s.length(); ++i)
        {
            char ch = s.charAt(i);
            char dh = t.charAt(i);
            if(map.containsKey(ch) && map.get(ch) != dh)
                return false;
            map.put(ch,dh);
        }
        return true;
    }
}
