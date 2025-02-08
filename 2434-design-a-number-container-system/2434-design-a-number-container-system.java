class NumberContainers {
  Map<Integer, Integer> mp;
  Map<Integer, TreeSet<Integer>> nmp;

  public NumberContainers() {
    this.mp = new HashMap<>();
    this.nmp = new HashMap<>();
  }

  public void change(int index, int number) {
    int num = 0;
    if (!this.mp.containsKey(index)) {
      this.mp.put(index, number);

    } else {
      int oldNum = this.mp.get(index);
      this.mp.put(index, number);

      this.nmp.get(oldNum).remove(index);

    }
    if (!this.nmp.containsKey(number)) {
      this.nmp.put(number, new TreeSet<>());
    }
    this.nmp.get(number).add(index);
  }

  public int find(int number) {
    if (this.nmp.containsKey(number)) {
      if (this.nmp.get(number) != null && this.nmp.get(number).size() > 0) {
        return this.nmp.get(number).first();
      }

    }

    return -1;
  }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */