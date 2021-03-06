public class Solution {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (A[mid] == target)
				return true;
			if (A[left] < A[mid]) {
				if (target >= A[left] && target <= A[mid])
					right = mid - 1;
				else
					left = mid + 1;
			} else if (A[mid] < A[left]) {
				if (target <= A[right] && target >= A[mid])
					left = mid + 1;
				else
					right = mid - 1;
			} else {
				if (A[left] == target)
					return true;
				while (A[left] == A[mid]) {
					left++;
					if( left > right )
						return false;
				}
			}
		}
		return false;
	}

}
