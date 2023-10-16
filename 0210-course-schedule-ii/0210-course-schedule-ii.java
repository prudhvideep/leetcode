class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] topOrder = new int[numCourses];
        int [] count = new int[numCourses];
        int size = prerequisites.length;
        int num = 0;

        for(int i = 0;i < size;i++){
            count[prerequisites[i][0]]++;
        }

        Queue <Integer> q = new LinkedList<>();
        for(int j = 0;j < numCourses;j++){
            if(count[j] == 0){
                q.add(j);
            }
        }
        int id = 0;
        while(q.size() > 0){
            int temp = q.poll();
            topOrder[id] = temp;

            for(int i = 0;i < size;i++){
                if(prerequisites[i][1] == temp){
                    count[prerequisites[i][0]]--;
                    if(count[prerequisites[i][0]] == 0)
                        q.add(prerequisites[i][0]);
                }
            }
            id++;num++;
        }
   
        if(num == numCourses){
            return topOrder;
        }

        return new int[0];


    }
}