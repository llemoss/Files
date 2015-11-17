print "FIBONACCI"
def fib(n):
    if (n==0 or n==1):
        return n
    else:
        result = fib(n-1) + fib(n-2)
        print result
        return result
N = input()
print fib(N)
