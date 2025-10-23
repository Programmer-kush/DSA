class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder current = new StringBuilder(s);
        
        while (current.length() > 2) {
            StringBuilder next = new StringBuilder();
            
            for (int i = 0; i < current.length() - 1; i++) {
                int digit1 = current.charAt(i) - '0';
                int digit2 = current.charAt(i + 1) - '0';
                int sumMod10 = (digit1 + digit2) % 10;
                next.append(sumMod10);
            }
            
            current = next;
        }
        
        return current.charAt(0) == current.charAt(1);
    }
}