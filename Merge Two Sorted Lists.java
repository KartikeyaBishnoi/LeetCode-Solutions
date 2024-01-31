/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 
*/

class Solution
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode returnNode = new ListNode();
        ListNode headNode = returnNode;
        ListNode L1 = list1;
        ListNode L2 = list2;

        while(L1 != null && L2 != null)
        {
            if(L1.val <= L2.val)
            {
                returnNode.next = L1;
                L1 = L1.next;
            }
            else
            {
                returnNode.next = L2;
                L2 = L2.next;
            }   
            returnNode = returnNode.next;         
        }
        if(L1 != null)
        {
            returnNode.next = L1;
            L1 = L1.next;
        }
        else if(L2 != null)
        {
            returnNode.next = L2;
            L2 = L2.next;
        }
        headNode = headNode.next;
        return headNode;
    }
}
