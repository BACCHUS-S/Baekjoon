while True:
    try:
        a=input()
    except EOFError:
        break
    except KeyboardInterrupt:
        break
    print(a)
