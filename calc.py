a = int(input("Enter the first number : "))
b = int(input("Enter the second number : "))
ch = int(input("Enter 1 for +, 2 for -, 3 for *, 4 for / : "))
if ch == 1:
    add = a + b
    print("The sum is : ", add)
elif ch == 2:
    sub = a - b
    print("The difference is : ", sub)
elif ch == 3:
    mul = a * b
    print("The product is : ", mul)
elif ch == 4:
    div = a / b
    rem = a % b
    print("The quotient is : ", div)
    print("The remainder is : ", rem)
else:
    print("Wrong choice")
