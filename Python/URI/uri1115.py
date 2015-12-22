print "URI 1115"
x, y = [int(i) for i in raw_input("").split(" ")]
while x != 0 or y != 0:
        if x > 0 and y > 0:
                print "primeiro"
        elif x < 0 and y > 0:
                print "segundo"
        elif x < 0 and y < 0:
                print "terceiro" 
        elif x > 0 and y < 0:
                print "quarto"
        elif x == 0 or y == 0:
                break
        x, y = [int(i) for i in raw_input("").split(" ")]

