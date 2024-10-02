class Solution:
    def splitWordsBySeparator(self, words: List[str], separator: str) -> List[str]:
        str = ""
        for word in words:
          str+=word
          str+=separator

        lis = str.replace(separator," ").split()

        return lis
