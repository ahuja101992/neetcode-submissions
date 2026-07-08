class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToAccId = new HashMap<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        // insert and creaye UF Data structure
        for(int i=0;i<n;i++){
            List<String> account = accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email = account.get(j);
                if(emailToAccId.containsKey(email)){
                    uf.union(i,emailToAccId.get(email));
                } else {
                    emailToAccId.put(email, i);
                }
            }
        }
        // extract the root account for each email and save 
        Map<Integer, List<String>> emailByParent = new HashMap<>(); 
        for(Map.Entry<String, Integer> entry: emailToAccId.entrySet()){
            String email = entry.getKey();
            int accountId = entry.getValue();
            int parent = uf.find(accountId);
            emailByParent.computeIfAbsent(parent, e-> new ArrayList<String>()).add(email);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: emailByParent.entrySet()){
            List<String> internalList = new ArrayList<>();
            int accountId = entry.getKey();
            List<String> emails= entry.getValue();
            Collections.sort(emails);
            internalList.add(accounts.get(accountId).get(0));
            internalList.addAll(emails);
            res.add(internalList);
        }
        return res;
    }
}

public class UnionFind{
    int[] parent;
    int[] size;
    int numOfComponents = 0;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] =i;
            size[i] = 1;
        }
        numOfComponents = n;
    }
    public int find(int curr){
        int root = curr;
        while(root!=parent[root]){
            root = parent[root];
        }
        // Path compression
        while(curr!= root){
            int temp = parent[curr];
            parent[curr] = root;
            curr = temp;
        }
        return root;
    }

    public int findComponentSize(int node){
        int parentNode = find(node);
        return size[parentNode];
    }
    public void union(int node1, int node2){
        int parentNode1 = find(node1);
        int parentNode2 = find(node2);
        if(parentNode1 == parentNode2){
            return;
        }
        if(size[parentNode1]> size[parentNode2]){
            parent[parentNode2] = parentNode1;
            size[parentNode1] += size[parentNode2]; 
        } else {
            parent[parentNode1] = parentNode2;
            size[parentNode2] += size[parentNode1];
        }
        numOfComponents--;
    }
}
