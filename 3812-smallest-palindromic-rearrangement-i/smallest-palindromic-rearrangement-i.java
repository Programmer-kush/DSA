class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int[] freq = new int[26];

        for (int i = (n + 1) / 2; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder half = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                half.append((char)('a' + i));
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(half);

        if (n % 2 == 1) {
            ans.append(s.charAt(n / 2));
        }

        ans.append(new StringBuilder(half).reverse());

        return ans.toString();
    }
}