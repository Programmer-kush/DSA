class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int num=num1;num<=num2;num++){
            if(num<=100) continue;
            List<Integer>list=new ArrayList<>();

            int n=num;
            while(n!=0){
                int digit=n%10;
                n/=10;
                list.add(digit);

            }

            for(int i=1;i<list.size()-1;i++){
                int d=list.get(i);
                if(d > list.get(i-1) && d > list.get(i+1)) ans++;
                else if(d < list.get(i-1) && d<list.get(i+1)) ans++;
            }


        }

        return ans;
    }
}