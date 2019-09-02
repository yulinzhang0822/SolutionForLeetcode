class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        int median = kthSmallestNumber(nums, m);
    
        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }
        
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
    }

    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();
    
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
    
        int l = 0, r = nums.length - 1;
        k--;
        
        while (l < r) {
            int m = getMiddle(nums, l, r);
        
            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    private int getMiddle(int[] nums, int l, int r) {
        int i = l;
    
        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < nums[l]) swap(nums, ++i, j);
        }
    
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
