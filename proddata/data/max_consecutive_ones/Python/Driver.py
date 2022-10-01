from Solution import Solution
from proddata.python.helpers import createIntArrayFromString
import sys
import os

# 2
# [1,1,0,1,1,1]
# 3
# [1,0,1,1,0,1]
# 2

file = open(os.path.join(sys.path[0], '../testcases.txt'), 'r')
lines = file.readlines()

isSolutionWrong = False
lineNumber = 1
solution = Solution()
for line in lines[1:]:
    line = line.strip()
    if lineNumber % 2 == 1:
        input = createIntArrayFromString(line)
        actualOutput = solution.findMaxConsecutiveOnes(input)
    else:
        expectedOutput = int(line)
        if (actualOutput != expectedOutput):
            print("Result: Failed")
            print("Actual Output: ", actualOutput)
            print("Expected Output: ", expectedOutput)
            isSolutionWrong = True
            break
    lineNumber += 1

if not isSolutionWrong:
    print("Result: Success")
