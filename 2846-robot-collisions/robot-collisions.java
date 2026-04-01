class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int arr[][] = new int[n][4]; // 4th column for original index

        for(int i = 0; i < n; i++){
            arr[i][0] = positions[i];
            arr[i][1] = healths[i];
            char ch = directions.charAt(i);
            arr[i][2] = (ch == 'R') ? 0 : 1;
            arr[i][3] = i; // store original index
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        Stack<Integer> st = new Stack<>(); // stores array index, not health
        List<int[]> ans = new ArrayList<>(); // stores [health, originalIndex]

        for(int i = 0; i < n; i++){
            int dir = arr[i][2];
            int hlt = arr[i][1];
            if(dir == 0){
                st.push(i); // push index
            }
            else{
                while(!st.isEmpty() && hlt > arr[st.peek()][1]){
                    st.pop();
                    hlt--;
                }
                if(st.isEmpty()){
                    if(hlt > 0) ans.add(new int[]{hlt, arr[i][3]});
                }
                else{
                    if(hlt == arr[st.peek()][1]){
                        st.pop();
                    }
                    else if(arr[st.peek()][1] > hlt){
                        arr[st.peek()][1]--; // decrement top's health directly
                    }
                }
            }
        }

        while(!st.isEmpty()){
            int idx = st.pop();
            ans.add(new int[]{arr[idx][1], arr[idx][3]});
        }

        // sort by original index
        ans.sort((a,b) -> a[1] - b[1]);

        List<Integer> result = new ArrayList<>();
        for(int[] a : ans) result.add(a[0]);
        return result;
    }
}