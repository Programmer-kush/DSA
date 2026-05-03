class Solution {
    public boolean isGood(int x){

        int temp=x;
        boolean flag=false;

        while(temp!=0){
            int digit=temp%10;
            if(digit==3 || digit==4 || digit==7) return false;
            temp=temp/10;

            if(digit==2 || digit==5 || digit==6 || digit==9) flag=true;


        }
        return flag;
        
    }
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)) count++;
        }
        return count;
    }
}