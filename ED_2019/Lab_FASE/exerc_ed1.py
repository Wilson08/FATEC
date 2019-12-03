
def competicao():
    max_value = int(input())
    lista = []
    yield 
    min_value = int(input())
    yield 
    lista.append(int(input()))
    yield 
    while len(lista) <= (max_value -1 ) :
        lista.append(int(input()))
        yield

    avarage = sum(lista) / len(lista)
    aprovados = list(filter(lambda x: x >= avarage , lista))
    aprovados.sort()
    first_item = aprovados.index(aprovados[min_value -1])
    result = len(aprovados[first_item:])
    yield result

input_value = None
teste = competicao()
for t in teste:
    if t is not None:
        print(t)