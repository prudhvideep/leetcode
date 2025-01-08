func countPrefixSuffixPairs(words []string) int {
    count := 0
    for i := 0; i < len(words);i++ {
      for j := i+1; j < len(words);j++ {
        if(isPrefixAndSuffix(words[i],words[j])){
          count++
        }
      }
    }

    return count
}

func isPrefixAndSuffix(s1,s2 string) bool {
  return strings.HasPrefix(s2,s1) && strings.HasSuffix(s2,s1)
}