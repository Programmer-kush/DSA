class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int ones = 0;
        int left = 0;
        int n = s.length();

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones == k) {
                int currLen = right - left + 1;
                String curr = s.substring(left, right + 1);

                if (currLen < minLen ||
                    (currLen == minLen && curr.compareTo(ans) < 0)) {
                    ans = curr;
                    minLen = currLen;
                }

                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }

        return ans;
    }
}