def prime(number):
    # Initialize a list
    primes = []
    for pr in range(2, number+1):
        isPrime = True
        for num in range(2, int(pr ** 0.5) + 1):
            if pr % num == 0:
                isPrime = False
                break
        if isPrime:
            primes.append(pr)
    return primes

def bitcount(n):
    return bin(n).count("1")