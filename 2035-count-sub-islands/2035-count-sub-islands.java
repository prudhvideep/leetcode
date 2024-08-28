class Solution {
    class Pair {
        int u;
        int v;

        public Pair(int src, int dst) {
            this.u = src;
            this.v = dst;
        }

        @Override
        public String toString(){
            return "u : " + u + " v : " + v; 
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        ArrayList<ArrayList<Pair>> islands = new ArrayList<>();

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    ArrayList<Pair> island = new ArrayList<>();
                    dfs(i, j, grid2, island);
                    islands.add(island);
                }
            }
        }

        int count = 0;

        for(ArrayList <Pair> island : islands){
            boolean isSubLand = true;
            for(Pair pair : island){
                int u = pair.u;
                int v = pair.v;

                if(grid1[u][v] != 1){
                    isSubLand = false;
                    break; 
                }
            }
            if(isSubLand){
                count++;
            }
        }

        return count;
    }

    public void dfs(int u, int v, int[][] grid2, ArrayList<Pair> island) {
        grid2[u][v] = 2;
        island.add(new Pair(u, v));

        if ((u - 1) >= 0 && grid2[u - 1][v] == 1) {
            dfs(u - 1, v, grid2, island);
        }

        if ((v - 1) >= 0 && grid2[u][v - 1] == 1) {
            dfs(u, v - 1, grid2, island);
        }

        if ((u + 1) < grid2.length && grid2[u + 1][v] == 1) {
            dfs(u + 1, v, grid2, island);
        }

        if ((v + 1) < grid2[0].length && grid2[u][v + 1] == 1) {
            dfs(u, v + 1, grid2, island);
        }

    }
}