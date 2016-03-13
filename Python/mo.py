coverPrice = 24.95
discount = 0.4
coverPrice = coverPrice * (1.0 - discount)
quantity = 60
shipping = 3 + (0.75*quantity-1)
total = (coverPrice * quantity) + shipping
print total
