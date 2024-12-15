def largest(list,n) :
    max = list[0]
    for i in range (1,n) :
        if list[i] > max :
            max = list[i]
    return max
n1 = int(input("Enter a number : "))
n2 = int(input("Enter a number : "))
n3 = int(input("Enter a number : "))
n4 = int(input("Enter a number : "))
n5 = int(input("Enter a number : "))
n6 = int(input("Enter a number : "))
n7 = int(input("Enter a number : "))
n8 = int(input("Enter a number : "))
n9 = int(input("Enter a number : "))
n10 = int(input("Enter a number : "))
list = [n1, n2, n3, n4, n5, n6, n7, n8, n9, n10]
n=10
ans= largest(list,n)
print("List : ",list)
print("Largest number : ",ans)