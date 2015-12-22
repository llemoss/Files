print "URI 1019"
time = input("Tempo em segundos: ")
time3600 = time % 3600
time60 = time3600 % 60
time1 = time60 % 1

print "%d:%d:%d" % (time/3600, time3600/60, time60/1)