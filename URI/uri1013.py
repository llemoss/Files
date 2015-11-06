print "URI 1013"
a, b, c = [int(i) for i in raw_input("").split(" ")]
MaiorAB = (a + b + abs(a-b))/2
MaiorABC = (MaiorAB + c + abs(MaiorAB - c))/2
print MaiorABC, "eh o maior"
