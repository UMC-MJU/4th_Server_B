n = int(input())
k = input()
s = list(map(int,str(k)))
sum = 0
for i in range(n):
    sum+=s[i]
print(sum)