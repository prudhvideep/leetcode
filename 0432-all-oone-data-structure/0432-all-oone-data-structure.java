class AllOne {
  TreeSet<String> set;
  Map<String, Integer> hm;

  public AllOne() {

    hm = new HashMap<>();
    set = new TreeSet<>((a, b) -> {
      int vala = hm.getOrDefault(a, 0);
      int valb = hm.getOrDefault(b, 0);
      if (vala == valb) {
        return a.compareTo(b);
      }
      return vala - valb;
    });
  }

  public void inc(String key) {
    set.remove(key);
    hm.put(key, hm.getOrDefault(key, 0) + 1);

    set.add(key);
  }

  public void dec(String key) {
    int ct = hm.get(key);
    set.remove(key);

    if (ct == 1) {
      hm.remove(key);
      return;
    }

    ct--;
    hm.put(key, ct);
    set.add(key);
  }

  public String getMaxKey() {
    if (!set.isEmpty()) {
      return set.last();
    }

    return "";
  }

  public String getMinKey() {

    if (!set.isEmpty()) {
      return set.first();
    }

    return "";
  }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */