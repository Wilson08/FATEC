
def main():
    min_value = -1
    andares = []

    print("Start the program please inform the A1, A2 and A3 values")
    for i in range(3):
        print("Choose a value  in ( 0 - 1000): \n")
        andares.append(next(get_Value()))

    calc_rec_andar = calcula_recurso_andar(andares)
    for andar in calc_rec_andar:
        if andar <= min_value or min_value == -1:
            min_value = andar
    print(f"\n the most choose returns a : {min_value} min.")

def calcula_recurso_andar(andares = []):
    yield ((andares[1]*2) + (andares[2]*4))
    yield (andares[0] *2 + andares[2]*2 )
    yield ((andares[0]*4) + (andares[1]*2))

def get_Value():
    while(True):
        value = int(input())
        yield value if  value >= 0 and value <= 1000 else None

main()