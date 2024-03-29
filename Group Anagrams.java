/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

  */

class Solution
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs)
        {
            String freqString = getFreqString(str);

            if(map.containsKey(freqString))
            {
                map.get(freqString).add(str);
            }
            else
            {
                List <String> list = new ArrayList<>();
                list.add(str);
                map.put(freqString, list);
            }
        }        
         return new ArrayList<>(map.values());

    }

    public String getFreqString(String str)
    {
        int freq[] = new int[26];
        for(char ch : str.toCharArray())
        {
            freq[ch-'a']++;
        }
        StringBuilder freqString = new StringBuilder();
        char c = 'a';
        for(int i : freq)
        {
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }
}
