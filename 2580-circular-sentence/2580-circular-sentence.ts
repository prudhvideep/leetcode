function isCircularSentence(sentence: string): boolean {
    let arr = sentence.split(" ")

    for(let i = 0; i < arr.length-1;i++){
      let fs = arr[i]
      let ss = arr[i+1]

      let fl = fs.length

      if(fs[fl-1] !== ss[0]){
        return false
      }
    }

    let lw = arr[arr.length-1]
    let fw = arr[0]

    if(fw[0] !== lw[lw.length-1]){
      return false
    }

    return true
};