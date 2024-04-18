/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
 


Intuition
The problem is asking us to calculate the perimeter of an island in a grid.
We can intuitively understand that the perimeter of an island would be the sum of all its edges.
In the grid, an edge is formed where a land cell (1) is adjacent to a water cell (0) or is on the boundary of the grid.

Approach
We iterate over each cell in the grid. For each cell that is land (1), we check its four sides (top, bottom, left, right).
If any side is either water (0) or on the boundary of the grid, we count it as part of the perimeter and increment our sum.

Complexity
Time complexity:
The time complexity is O(m×n),
where m is the number of rows and n is the number of columns in the grid. This is because we are iterating over each cell in the grid once.
Space complexity:
The space complexity is O(1),
as we are not using any additional data structures whose size scales with the input size.
Code
*/

class Solution
{
    public int islandPerimeter(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = 0;

        for(int i=0; i<rows; ++i)
        {
            for(int j = 0; j<cols; ++j)
            {
                if(grid[i][j] == 1)
                {
                    if(i == 0 || grid[i-1][j] == 0) // top
                        sum++;
                    if(i == rows-1 || grid[i+1][j] == 0) // bottom
                        sum++;
                    if(j == 0 || grid[i][j-1] == 0) // left
                        sum++;
                    if(j == cols-1 || grid[i][j+1] == 0) // right
                        sum++;
                }
            }
        }
        return sum;
    }
}
