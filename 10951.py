while True:
    try:
        a,b=map(int,input().split())
    except EOFError:
        break
    except KeyboardInterruput:
        break
    else:
        print(a+b)
