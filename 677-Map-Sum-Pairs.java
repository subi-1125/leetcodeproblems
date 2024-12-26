class MapSum {
    class Node{
        Node children[] = new Node[26];
        int val=0;
    }
    Node root;
    public MapSum() {
        root = new Node();
        
    }
    
    public void insert(String key, int val) {
        Node temp = root;
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(temp.children[ch-'a'] == null){
            temp.children[ch-'a']=new Node();
        }
            temp=temp.children[ch-'a'];
        }
        temp.val = val;   
    }
    int ans;
    public int sum(String prefix) {
        Node temp = root;
        for(int i=0;i<prefix.length();i++){
            char ch =prefix.charAt(i);
            if(temp.children[ch-'a']==null){
            return 0;
            }
            temp=temp.children[ch-'a'];
        }
        ans=0;
        helper(temp);
        return ans;     
    }
    void helper(Node node){
        ans += node.val;
        for(Node child:node.children){
            if(child!=null)
            helper(child);
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */