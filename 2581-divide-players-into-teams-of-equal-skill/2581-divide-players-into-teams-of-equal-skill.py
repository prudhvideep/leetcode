class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        tot_sum = 0
        n = len(skill)
        count = [0 for i in range(1001)]

        for s in skill:
          tot_sum+=s
          count[s] += 1
          if count[s] == n:
            return int((n/2) * (s ** 2))
        
        
        if n == 2:
          return (skill[0] * skill[1])

        if (tot_sum % (n/2)) != 0:
          return -1
                
        ret = 0
        reqSum = int((tot_sum / (n/2)))
        for s in skill:
          if count[s] > 0:
            print(count[s])
            count[s] -= 1

            if count[reqSum - s] > 0:
              count[reqSum - s] -= 1
              ret += ((reqSum-s) * s)
            else:
              return -1
        
        return ret

        