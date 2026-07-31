class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int pushes = 1;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            ans += freq[i] * pushes;
            if ((25 - i + 1) % 8 == 0) pushes++;
        }

        return ans;
    }
}