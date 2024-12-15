def find_primes(a):
    primes = []
    for num in a:
        if num > 1:  # 1 is not a prime number
            for i in range(2, int(num ** 0.5) + 1):
                if num % i == 0:
                    break
            else:
                primes.append(num)
    return primes
a=[]
for i in range(10):
    element = input(f"Enter element {i+1}: ")
    a.append(element)

print(find_primes(a))

print("List:", a)
