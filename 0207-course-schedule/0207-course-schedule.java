class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int size = prerequisites.length;
        Queue <Integer> q = new LinkedList<>();

        //Number of courses we can complete with the dependencies
        int num = 0;

        //calculate the incount of vertices
        int [] count = new int[numCourses];

        for(int i = 0;i < size;i++){
            count[prerequisites[i][0]]++;
        }

        //Add all the vertices with no dependency to the queue
        for(int j = 0;j < numCourses;j++){
            if(count[j] == 0)
                q.add(j);
        }

        //initiate the BFS
        while(q.size() > 0){
            int temp = q.poll();

            for(int k = 0;k < size;k++){
                if(prerequisites[k][1] == temp){
                    count[prerequisites[k][0]]--;
                    if(count[prerequisites[k][0]] == 0)
                        q.add(prerequisites[k][0]);
                }
            }
            num++;
        }

        return numCourses == num;


    }
}