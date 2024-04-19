/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Intuition
The problem is about finding the number of islands in a 2D grid.
An island is defined as a group of '1’s (land) that are connected horizontally or vertically, and surrounded by '0’s (water). 
The intuition behind the solution is to traverse the grid and start a Depth-First Search (DFS) whenever we encounter land (‘1’), marking all the connected land as visited.

Approach
The approach is to iterate over each cell in the grid. If the cell contains a ‘1’, we increment our island count and then perform a DFS to mark all cells in the current island as visited. 
The DFS traverses the grid in all four directions (up, down, left, right) and marks any encountered land as visited by setting their value to ‘0’. 
This way, we ensure that each island is counted only once.

Complexity
Time complexity:
The time complexity is O(m×n),
where m is the number of rows and
n is the number of columns in the grid.
This is because in the worst case, we might end up visiting every single cell in the grid.
Space complexity:
The space complexity is O(m×n),
in the worst case, due to the space required by the call stack during the DFS traversal. 
In the worst case, the grid is filled with lands, and DFS goes by m×n deep.
Code
*/

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    clearRestOfLand(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        clearRestOfLand(grid, i+1, j);
        clearRestOfLand(grid, i-1, j);
        clearRestOfLand(grid, i, j+1);
        clearRestOfLand(grid, i, j-1);
        return;
    }
}
