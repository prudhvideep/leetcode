func isCircularSentence(sentence string) bool {
    spl := strings.Split(sentence, " ")

    for i := 0; i < len(spl)-1;i++{
      fs := spl[i]
      ss := spl[i+1]

      if(fs[len(fs)-1] != ss[0]){
        return false
      }
    }

    fw := spl[0]
    lw := spl[len(spl)-1]

    if(fw[0] != lw[len(lw)-1]){
      return false
    }
    return true
}