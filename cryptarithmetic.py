import time

def solve(problem, assignment={}):
    """
    Solve the cryptarithmetic puzzle and return the solution if it exists.
    Arguments are a list of strings and the current assignment as a dictionary 
    """
    # If all characters are assigned, check if the problem is solved
    if len(assignment) == len(problem):
        # Find the numerical value of each string
        s1 = sum([10**i * assignment[c] for i, c in enumerate(str1[::-1])])
        s2 = sum([10**i * assignment[c] for i, c in enumerate(str2[::-1])])
        s3 = sum([10**i * assignment[c] for i, c in enumerate(str3[::-1])])
        # Verify the sum and return the assignment if it is correct
        if s1 + s2 == s3:
            return assignment

    # Try to assign a digit to the next character
    for c in problem:
        # Proceed only if the character is not already assigned (unique assignment)
        if c not in assignment:
            # Try each digit from 0 to 9 that is not already assigned
            for d in range(10):
                # Assigning 0 to the first character of a string is not allowed
                if d == 0 and (c == str1[0] or c == str2[0] or c == str3[0]):
                    continue
                if d not in assignment.values():
                    assignment[c] = d
                    # Recursively solve the problem with the new assignment
                    result = solve(problem, assignment)
                    # If the problem is solved, return the assignment
                    if result:
                        return result
                    # Else, remove the assignment and try the next digit
                    del assignment[c]
    # If no solution is found
    return None

str1 = list(input("String 1: "))
str2 = list(input("String 2: "))
str3 = list(input("Sum: "))

# List of all characters used in the problem
chars = list(set(str1 + str2 + str3))

# Solve the problem 
start_time = time.time()
assignment = solve(chars) or "No solution"
end_time = time.time()

# Output
for c in chars:
    print(f"{c}: {assignment[c]}", end=" ")
print()
print(f"{end_time - start_time}s")
