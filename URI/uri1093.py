from random import randrange
EV1, EV2, AT, D = [int(i) for i in raw_input("").split(" ")]
V1 = 0
V2 = 0
#while EV1 <= 1 and EV2 <= 10 and (AT >= 1 and AT <= 5) and (D <= 1 and D >= 10):
while EV1 != 0 or EV2 != 0:
#        EV1, EV2, AT, D = [int(i) for i in raw_input("").split(" ")]
        dice = randrange(1,7)
        if dice <= AT:
                EV1 = EV1 + D
                EV2 = EV2 - D
                N = EV1 + EV2
                V1 = V1 + 1
                P = float(EV1/N)
                print P
        else:
                EV1 = EV1 - D
                EV2 = EV2 + D
                V2 = V2 + 1
                N = EV1 + EV2
                P = float(EV2/N)
                print P
        if V1 == 2 or V2 == 2:
                break
                print P
else:
        print P
'''
                if V2 == 2 or V1 == 2:
                        P = EV2/(EV1 + EV2)
                        print P
                        break
'''
