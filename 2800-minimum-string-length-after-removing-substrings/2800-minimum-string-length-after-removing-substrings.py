class Solution:
    def minLength(self, s: str) -> int:
        while True:
          patFound = False
          for i in range(len(s)-1):
            if s[i] == 'A' and s[i+1] == 'B':
              s = s[:i] + s[(i+2):]
              patFound = True 
              break
            
            if s[i] == 'C' and s[i+1] == 'D':
              s = s[:i] + s[(i+2):]
              patFound = True
              break
          
          if not patFound: 
            break

        return len(s)

            
