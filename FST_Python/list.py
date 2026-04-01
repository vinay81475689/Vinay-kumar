# Function to check if first and last numbers are identical
def first_and_last_same(numbers):
    if not numbers:
        return False
    # numbers[0] is the first element, numbers[-1] is the last
    return numbers[0] == numbers[-1]

# Bonus: Accepting user input
user_input = input("Enter numbers separated by spaces: ")
# Convert input string into a list of integers
user_list = [int(num) for num in user_input.split()]

# Output the result
print(f"Result: {first_and_last_same(user_list)}")
