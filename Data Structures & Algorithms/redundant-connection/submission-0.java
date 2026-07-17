class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length+1);
        int[] res= new int[2];
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                res = edge;
            }
        }
        return res;
    }
}
class UnionFind{
    int[] parent;
    int[] size;
    int numOfComponents;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        numOfComponents = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] =0;
        }
    }

    public int find(int curr){
        int root = curr;
        while(root != parent[root] ){
            root = parent[root];
        }
        // path compression
        while(curr!=root){
            int temp = curr;
            curr = parent[curr];
            parent[curr] = root;
        }
        return root;
    }
    public int findComponentSize(int node){
        int parent = find(node);
        return size[parent];
    }
    public boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB){
            return false;
        }
        //merge B to A
        if(size[parentA]>size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        } else {
            parent[parentA] = parentB;
            size[parentB] +=parentA;
        }
        numOfComponents--;
        return true;
    }


}
