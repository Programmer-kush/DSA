class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k) return "0";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && st.peek() > ch && k>0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k-- > 0){
            st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int ind=0;
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
    
        return sb.toString();
    }
}