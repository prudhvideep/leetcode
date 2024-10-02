class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        newList = list(arr)
        newList.sort()
        
        keyMap = {}
        
        count = 0
        for key in newList:
          if key in keyMap:
            continue
          else:
            count += 1
            keyMap[key] = count
         
        for i in range(len(arr)):
          newList[i] = keyMap.get(arr[i])
        
        return newList