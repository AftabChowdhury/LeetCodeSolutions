class Solution {
  public int search(int[] nums, int target) {
		 int left, right, result = -1;
		 int n = nums.length;
		 if(n==0) return -1;
		 if(n==1) {
			 if(nums[0]==target) {
				 return 0;
			 } else {
				 return -1;
			 }
		 }
		 if(n==2) {
			 if(nums[0]==target) {
				 return 0;
			 } else if(nums[1]==target){
				 return 1;
			 } else {
				 return -1;
			 }
		 }
		 int pivot = pivot_search(nums, n);
		 System.out.println(pivot);
		 if(pivot == -1) {
			 left = 0;
			 right = n-1;
			 result=binary_search(nums, left, right, target);
		 } else {
			 if(nums[pivot]==target) {
				 return pivot;
			 }
			 if(nums[pivot]< target && nums[n-1] >= target) {
				 left = pivot;
				 right = n-1;
				 result=binary_search(nums, left, right, target);
			 } else {
				 left = 0;
				 right = pivot-1;
				 result=binary_search(nums, left, right, target);
			 }
		 }
		 
		 return result;
	 }
	 
	 // find the pivot
	 public int pivot_search(int [] nums, int n) {
		 int left, right, mid;
		 left = 0;
		 right = n-1;
		 int count = 0;
		 while(left<=right) {
             count++;
			 if(count>n) return -1;
			 mid = (left+right)/2;
             if(mid==0 && nums[mid]>nums[mid+1]) {
				 return mid+1;
			 }
			 if(mid-1<0 || mid+1>n-1) return -1;
			 if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
				 return mid+1;
			 }
			 if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) {
				 return mid;
			 }
			 if(nums[left]>nums[mid]) {
				 right = mid-1;
			 }
			 if(nums[left]<nums[mid]) {
				 left = mid+1;
			 }
		 }
		 return -1;
	 }
	// find the target
	 public int binary_search(int [] nums, int left, int right, int target) {
		 int mid;
		 
		 while(left<=right) {
			 mid = (left+right)/2;
			 if(nums[mid]==target) {
				 return mid;
			 }
			 if(nums[mid]<target) {
				 left = mid+1;
			 } else {
				 right = mid-1;
			 }
		 }
		 return -1;
	 }
}