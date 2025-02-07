func areAlmostEqual(s1 string, s2 string) bool {
   n := len(s1)
   count := 0

   ca1 := make([]int,26)
   ca2 := make([]int,26)

   for _,c := range s1 {
    ca1[c - 'a']++
   }

   for _,c := range s2 {
    ca2[c - 'a']++
   }

   for i := 0; i < 26;i++ {
     if ca1[i] != ca2[i] {
      return false
     }
   }

   for i := 0;i < n;i++ {
    if s1[i] != s2[i] {
      count++
    } 
   }

   if count > 2 {
    return false
   }

   return true
}