class LockingTree {
    public int[] lock;
    public int[] parent;
    public Map <Integer,List<Integer>> des ;

    public LockingTree(int[] parent) {
        lock = new int[parent.length];
        this.parent = parent;
        this.des = new HashMap<>();
        
        for(int i = 0;i <= parent.length-1;i++){
           this.des.put(i,new ArrayList<> ());
        }

        System.out.println(des);

        for(int i = 1;i < parent.length;i++){
            this.des.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (lock[num] == 0) {
            lock[num] = user;
            return true;
        }

        return false;
    }

    public boolean unlock(int num, int user) {
        if (lock[num] == user) {
            lock[num] = 0;
            return true;
        }

        return false;
    }

    public boolean upgrade(int num, int user) {
        if (lock[num] != 0) {
            return false;
        }

        int a = num;
        while (a != -1) {
            if (parent[a] != -1 && lock[parent[a]] != 0) {
                return false;
            }

            a = parent[a];
        }
        
        int count = checkDesc(num);

        if(count == 0){
            return false;
        }

        lock[num] = user;

        return true;
    }

    public int checkDesc(int num) {
        int count = 0;
        
        if(des.get(num) == null || (des.get(num) != null && des.get(num).size() == 0))
            return count;
        
        for(int desc : des.get(num)){
            if(lock[desc] != 0){
                count++;
            }
            lock[desc] = 0;
            count += checkDesc(desc);
        }

        return count;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */