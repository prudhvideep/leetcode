func isPrefix(word string, sWord string) bool {
  if len(sWord) > len(word) {
    return false
  }
    
  for i := 0; i < len(sWord); i++ {
    if word[i] != sWord[i] {
      return false
    }
  }

  return true

}

func isPrefixOfWord(sentence string, searchWord string) int {
    words := strings.Split(sentence," ")

    for i := 0; i < len(words);i++ {
      if isPrefix(words[i],searchWord){
        return i+1
      }
    }

    return -1
}