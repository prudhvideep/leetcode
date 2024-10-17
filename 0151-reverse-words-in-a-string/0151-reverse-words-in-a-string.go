func reverseWords(s string) string {
    t := strings.TrimSpace(s)
    a := strings.Split(t," ")
    ret := ""
    
    b := []string{}
    for _,str := range a{
        str = strings.ReplaceAll(str," ","")

        if len(str) != 0{
          b = append(b,str)
        }
    }

    reverse(b)

    for i := range b{
      if i == 0{
        ret += b[i]
        continue
      }

      ret+= " " + b[i]
    }

    return ret
}

func reverse(r []string) []string{
  l,h := 0,len(r)-1
  

  for l <= h{
    var temp = r[l]
    r[l] = r[h]
    r[h] = temp

    l++
    h--
  }

  return r
}