class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return false;
            }
        }
        return uf.numOfComponents ==1;
    }
}

public class UnionFind{
    int[] parent;
    int[] size;
    int numOfComponents;

    UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        numOfComponents = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] =1;
        }
    }

    public int find(int node){
        int root = node;
        while(root!=parent[root]){
            root = parent[root];
        }
        while(node!=root){
            int temp = parent[node];
            parent[node] = root;
            node = temp;
        }
        return root;
    }

    public boolean union(int node1, int node2){
        int parentNode1 = find(node1);
        int parentNode2 = find(node2);

        if(parentNode1 == parentNode2){
            return false;
        }

        if(size[parentNode1]> size[parentNode2]){
            parent[parentNode2] = parentNode1;
            size[parentNode1] += size[parentNode2];
        } else {
            parent[parentNode1] = parentNode2;
            size[parentNode2] += size[parentNode1];
        }
        numOfComponents--;
        return true;
    }
}