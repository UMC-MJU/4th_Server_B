count = 0
a =0
for i in range(9):
    b = int(input())
    if a<b:
        count = i
        a = b
print(a)
print(count+1)