try:
    raise ValueError
except ValueError:
    print("Foo")
except:
    print("Bar")
else:
    print("Foo Bar")
finally:
    print("FooBarFoo")
print("FooBarFoo")
