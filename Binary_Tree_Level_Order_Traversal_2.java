/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//*****************************************************************
//						1. iterative method
//*****************************************************************
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if( root == null ) return ans;
		ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
		arr.add( root );
		int end = arr.size();
		int cur = 0;
		while( cur < arr.size() )
		{
			ArrayList<Integer> level = new ArrayList<Integer>();
			end = arr.size();
			while( cur < end )
			{
				TreeNode node = arr.get(cur);
				level.add(node.val);
				if( node.left != null )
					arr.add( node.left );
				if( node.right != null )
					arr.add( node.right );
				cur++;
			}
			ans.add(level);
		}
		int i = 0;
		int j = ans.size() - 1;
		while( i < j )
		{
			ArrayList<Integer> ans_left = ans.get(i);
			ArrayList<Integer> ans_right = ans.get(j);
			ArrayList<Integer> ans_tmp = ans_left;
			ans_left = ans_right;
			ans_right = ans_tmp;
			i++;
			j--;
		}
		return ans;
	}
}


//*****************************************************************
//						2. recursive method
//*****************************************************************
public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int height = getHeight( root );
		for( int i = 0; i < height; ++i )
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			ans.add(tmp);
		}
		levelOrderCore( root, 0, ans );
		return ans;
	}
	public void levelOrderCore( TreeNode root, int depth, ArrayList<ArrayList<Integer>> ans )
	{
		if( root == null ) return;
		ArrayList<Integer> level = ans.get( ans.size() - depth - 1 );
		level.add( root.val );
		levelOrderCore( root.left, depth + 1, ans );
		levelOrderCore( root.right, depth + 1, ans );
	}
	public int getHeight( TreeNode root )
	{
		if( root == null )
			return 0;
		int left = getHeight( root.left );
		int right = getHeight( root.right );
		return Math.max( left , right ) + 1;
	}
}
