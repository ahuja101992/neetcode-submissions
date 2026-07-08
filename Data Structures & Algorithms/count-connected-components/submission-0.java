class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf= new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.numOfComponents;
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
            size[i] = 0;
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
            size[parentNode1] +=parentNode2; 
        } else {
            parent[parentNode1] = parentNode2;
            size[parentNode2] += parentNode1;
        }
        numOfComponents--;
    }
}
