print "URI 1064"
num1 = input()
num2 = input()
num3 = input()
num4 = input()
num5 = input()
num6 = input()

i = 0

if num1 > 0:
    i = i + 1
    m1 = num1
else:
    m1 = 0

if num2 > 0:
    i = i + 1
    m2 = num2
else:
    m2 = 0

if num3 > 0:
    i = i + 1
    m3 = num3
else:
    m3 = 0

if num4 > 0:
    i = i + 1
    m4 = num4
else:
    m4 = 0

if num5 > 0:
    i = i + 1
    m5 = num5
else:
    m5 = 0

if num6 > 0:
    m6 = num6
    i = i + 1
else:
    m6 = 0

media = (m1+m2+m3+m4+m5+m6)/i
media = float(media)

print i, "valores positivos"
print "%.1f" % media
