/*Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

 #############################################################################################################################################################################################################

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".


 #############################################################################################################################################################################################################

  */

class Solution{
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(int i=0; i<len1; ++i)
        {
            for(int j=0; j<len2; ++j)
            {
                if(list1[i].equals(list2[j]))
                {
                    map.put(list1[i],i+j);
                }
            }
        }
        int min = 9999;
        for(Map.Entry m : map.entrySet()){  
            int val =(Integer) m.getValue();
            if(val<min)
                min = val;
        }
        int count=0;
        for(Map.Entry m : map.entrySet()){  
            int val =(Integer) m.getValue();
            if(val == min)
                count++;
        }
        String result[] = new String[count];
        count = 0;
        for(Map.Entry m : map.entrySet()){  
            int val =(Integer) m.getValue();
            if(val == min)
                result[count++] =(String) m.getKey();
        }
        return result;        
    }
}
