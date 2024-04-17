/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

 

Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
 

Constraints:

The number of nodes in the tree is in the range [1, 8500].
0 <= Node.val <= 25



Intuition
The problem requires finding the lexicographically smallest string that starts at a leaf node and ends at the root in a given binary tree. 
We can achieve this by performing a depth-first traversal (DFS) of the tree.

Approach
Initialize a global variable smallest to store the smallest string found during traversal.
Implement a recursive function makeSequence(TreeNode root, String str):
If root is null, return.

Append the character corresponding to the node’s value to the current string str.

If root is a leaf node (both left and right children are null):

Compare str with the smallest string found so far (smallest).

If smallest is null or str is lexicographically smaller, update smallest.
3. Recursively call makeSequence for the left and right subtrees.
Return the value of smallest.

Complexity
Time complexity:
Time complexity: The DFS traversal visits each node once, so the time complexity is O(n), where n is the number of nodes in the tree.
Space complexity:
The recursive call stack uses O(h) space, where h is the height of the tree (maximum depth). 
In the worst case (unbalanced tree), h can be equal to n, resulting in O(n) space usage. However, for a balanced tree, the space complexity is O(log n).
Code
  */
class Solution {
    String smallest;

    public String smallestFromLeaf(TreeNode root) {
        makeSequence(root, "");
        return smallest;
    }

    private void makeSequence(TreeNode root, String str) {
        if (root == null)
            return;
        
        str = (char) (97 + root.val) + str;

        if (root.left == null && root.right == null)
        {
            if (smallest == null || str.compareTo(smallest) < 0)
                smallest = str;            
            return;
        }
        makeSequence(root.left, str);
        makeSequence(root.right, str);
    }
}

