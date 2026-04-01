numbers = (10, 23, 45, 67, 50, 12, 5)

result = []

for num in numbers:
    if num % 5 == 0:
        result.append(num)

print(result)