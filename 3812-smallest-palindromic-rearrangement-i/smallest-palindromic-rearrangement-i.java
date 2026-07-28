class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n<=1) return s;
        
        char[] sb = s.substring((n + 1) / 2).toCharArray();
        Arrays.sort(sb);

        String half = new String(sb);
        String ans = half;

        if (n % 2 == 1)
            ans += s.charAt(n / 2);

        ans += new StringBuilder(half).reverse().toString();
            
        return ans;
            }
}