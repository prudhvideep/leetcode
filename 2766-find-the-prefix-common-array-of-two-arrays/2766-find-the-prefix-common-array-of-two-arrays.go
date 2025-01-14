func findThePrefixCommonArray(A []int, B []int) []int {
	n := len(A)
	count := make([]int, n)

	hash := make([]int, 51)

	for i, v := range A {
		hash[v] = i
	}

	for i,v := range B {
    id := max(hash[v],i)
    count[id]++
  }

  for i:=1; i < n;i++ {
    count[i] += count[i-1]
  }

  return count
}