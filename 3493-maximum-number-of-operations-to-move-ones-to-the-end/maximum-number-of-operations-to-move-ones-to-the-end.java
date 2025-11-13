class Solution {
    public int maxOperations(String s) {
        int count=0;
        int total=0;

        
        int n=s.length();
        for(int i=0;i<n;i++){
            
            char ch=s.charAt(i);
            if(i>0 && ch=='0' && s.charAt(i-1)=='0') continue;
            if(ch=='1'){
                count++;
            }
            if(ch=='0'){
                total+=count;
            }
        }
    
        return total;
    }
}