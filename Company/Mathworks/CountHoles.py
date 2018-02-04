def count_holes(x):
    dHoles = {'0': 1, '6': 1, '8': 2, '9': 1, '0': 1}

    counter = 0
    for digit in str(x):
        counter += dHoles.get(digit, 0)

    return counter

print(count_holes(860))
