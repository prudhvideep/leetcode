func isPrefix(word string, sWord string) bool {
  
  return strings.HasPrefix(word,sWord)

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