N = int(input())
for _ in range(N):
    F = int(input())
    LIST, TOTAL_SET = [], set()
    for f in range(F):
        X,Y = input().split()
        if X in TOTAL_SET and Y in TOTAL_SET:
            pop_index = []
            for idx, list_item in enumerate(LIST):
                if X in list_item: pop_index.append(idx)
                if Y in list_item: pop_index.append(idx)
            if(len(set(pop_index)) == 2):
                pop_index.sort(reverse=True)
                set1 = LIST.pop(pop_index[0])
                set2 = LIST.pop(pop_index[1])
                set1.update(set2)
                print(len(set1))
                LIST.append(set1)
            else: print(len(LIST[pop_index[0]]))
        elif X in TOTAL_SET or Y in TOTAL_SET:
            for idx, list_item in enumerate(LIST):
                if (X in list_item) or (Y in list_item):
                    LIST[idx].update([X,Y])
                    TOTAL_SET.update([X,Y])
                    print(len(LIST[idx]))
                    break
        else:
            LIST.append({X,Y})
            TOTAL_SET.update([X,Y])
            print(2)