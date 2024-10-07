class Solution:
    def minLength(self, s: str) -> int:
        stack = []

        for c in s:
          if len(stack) == 0:
            stack.append(c)
            continue
          
          if c == 'D' and stack[-1] == 'C':
            stack.pop()
            continue

          if c == 'B' and stack[-1] == 'A':
            stack.pop()
            continue
          
          stack.append(c)
        
        return len(stack)