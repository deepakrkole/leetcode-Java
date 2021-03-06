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
	public boolean isSymmetric(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if( root == null ) return true;
		return isSymmetric( root.left, root.right );
	}
	public boolean isSymmetric( TreeNode left, TreeNode right ) 
	{
		if( left == null && right == null ) return true;
		if( left == null || right == null ) return false;
		if( left.val != right.val ) return false;
		boolean bleft = isSymmetric( left.right, right.left );
		boolean bright = isSymmetric( left.left, right.right );
		return bleft && bright ;
	}
}
