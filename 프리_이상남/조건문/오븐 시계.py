import sys
a, b = list(map(int, sys.stdin.readline().split()))
c = int(sys.stdin.readline())

a = c // 60 + a
b = c % 60 + b

if b>=60:
    a += 1
    b -= 60
if a>=24:
    a -= 24
print(a,b)