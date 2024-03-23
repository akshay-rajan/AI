def isValid(char, digit, ans):
    # For each character-digit pair
    for c, d in ans.items():
        # If the character is already assigned to a digit
        if digit != 0 and char == c:
            return False
        # If the digit is already assigned to a character
        if digit == 0 and d != 0 and d == char:
            return False
    return True

def solve(integer, position):
    """Solve the crypt-arithmetic problem"""
    
    # If all characters are assigned valid digits
    if integer == 0: return True
    
    # If we reached the end of the list without finding a valid assignment
    if position == char_count: return False

    # Get the character based on the position
    c = chars[position]
    # For each digit, check if the assignment to the current character is valid
    for digit in range(10):
        if isValid(c, digit, ans):
            # Update the answer dictionary
            ans[c] = digit
            # Recursively call the function with updated value
            if solve(integer - digit * 10 ** position, position + 1):
                # If a valid assignment has been found for each character, return True
                return True
            # If no valid assignment is found for some character, reset the current character's value and continue
            ans[c] = 0

    return False


char_count = 0
str1, str2, str3 = [char for char in input("String 1: ")], [char for char in input("String 2: ")], [char for char in input("Sum: ")]

# List of all characters used
chars = list(set(str1 + str2 + str3))
char_count = len(chars)
print(char_count)

# Assign a digit to each character
ans = {}

if solve(int(str3), 0):
    print(ans)
else:
    print("No solution")
