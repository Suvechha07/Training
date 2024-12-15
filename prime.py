a=int(input("Enter a number : "))
c=0
for i in range(1,a):
    if a%i==0:
        c=c+1
if c>2 :
    print("It is not a prime number")
else :
    print("It is a prime number")
