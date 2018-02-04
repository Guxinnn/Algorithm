def merge(a, b):
    res = ""
    for i in range(min(len(a), len(b))):
        res += a[i]
        res += b[i]

    if len(a) > len(b):
        res += a[-1]
    elif len(b) > len(a):
        res += b[-1]

    return res

print(merge('abch', 'def'))
