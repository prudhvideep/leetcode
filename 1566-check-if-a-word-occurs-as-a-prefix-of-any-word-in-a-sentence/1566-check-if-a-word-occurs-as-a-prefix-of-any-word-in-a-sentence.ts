function isPrefix(word : string, sWord : string) : boolean{
  if(sWord.length > word.length) return false

  for(let i = 0;i < sWord.length;i++){
    if(sWord[i] !== word[i]){
      return false
    }
  }

  return true
}

function isPrefixOfWord(sentence: string, searchWord: string): number {
    let words = sentence.split(" ")

    for(let i = 0;i < words.length;i++){
      if(isPrefix(words[i],searchWord)){
        return i+1
      }
    }

    return -1
};