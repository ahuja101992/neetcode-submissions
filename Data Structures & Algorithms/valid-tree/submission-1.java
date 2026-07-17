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
            size[i] = 1;
        }
    }

    public int find(int curr){
        int root = curr;
        while(root!=parent[root]){
            root = parent[root];
        }
        while(curr!=root){
            int temp = parent[curr];
            parent[curr] = root;
            curr= temp;
        }
        return root;
    }

    public int sizeOfComponent(int node){
        int parent = find(node);
        return size[parent];
    }

    public boolean union( int node1, int node2){
        int parentOfNode1 = find(node1);
        int parentOfNode2 = find(node2);

        if(parentOfNode1 == parentOfNode2){
            return false;
        }

        if(size[parentOfNode1]> size[parentOfNode2]){
            parent[parentOfNode2] = parentOfNode1;
            size[parentOfNode1] += size[parentOfNode2];
        } else {
            parent[parentOfNode1] = parentOfNode2;
            size[parentOfNode2] += size[parentOfNode1];
        }
        numOfComponents--;

        return true;
    }
}
