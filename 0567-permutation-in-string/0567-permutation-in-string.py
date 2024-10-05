class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False

        ct1 = [0 for i in range(26)]
        ct2 = [0 for i in range(26)]

        for c in s1:
            id = ord(c) - ord("a")
            ct1[id] += 1

        i2 = 0

        for i in range(len(s1)):
            id = ord(s2[i]) - ord("a")
            ct2[id] += 1

        if ct1 == ct2:
            return True

        for i in range(1, (len(s2) - len(s1) + 1)):
            c = s2[i - 1]
            id = ord(c) - ord("a")

            ct2[id] -= 1

            d = s2[i + len(s1) - 1]
            id1 = ord(d) - ord("a")
            ct2[id1] += 1

            if ct2 == ct1:
                return True

        return False
