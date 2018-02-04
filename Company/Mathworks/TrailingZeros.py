# import math
#
# def trailingZeros(n):
#     zeroCnt = 0
#
#     while n > 0:
#         n = (math.floor)(n / 5)
#         zeroCnt += n
#
#     return zeroCnt
#
# print(trailingZeros(12))

x = 10
y = 20

def printNumbers():
    def calc():
        global x
        x *= 10
        y = 200
    calc()
    print("(x,y) = (%s, %s)" % (x,y))

if __name__ == '__main__':
    print("(x,y) = (%s,%s)" % (x,y))
    printNumbers()
