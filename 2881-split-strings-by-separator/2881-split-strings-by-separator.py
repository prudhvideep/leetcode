class Solution:
    def splitWordsBySeparator(self, words: List[str], separator: str) -> List[str]:
        lis = []

        for word in words:
            for splitW in word.split(separator):
              if len(splitW) > 0 :
                lis.append(splitW)

        return lis
