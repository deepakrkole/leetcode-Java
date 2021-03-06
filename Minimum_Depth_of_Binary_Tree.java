/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
	public int minDepth(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( root == null ) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if( left == 0 || right == 0 )
			return Math.max( left , right ) + 1;
		return Math.min( left, right ) + 1;
	}
}
