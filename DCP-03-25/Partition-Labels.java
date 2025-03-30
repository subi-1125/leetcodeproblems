class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>ans=new ArrayList<>();
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i; 
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,arr[s.charAt(i)-'a']);
            if(end==i){
                ans.add(end-start+1);
                start=i+1;
            }
        }
        return ans;
    }
}