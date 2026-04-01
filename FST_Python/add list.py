result=[]
list1=[1,2,3,4]
list2=[5,6,7,8]
for num in list1:
    if num % 2 != 0:
        result.append(num)

for num in list2:
    if num % 2 == 0:
        result.append(num)
print(result)