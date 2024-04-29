from AtletaPython import Atleta
def cadastrar_atleta(Hash, nome, apelido, fone, data_nascimento, pontuacao):
    jogador = Atleta(nome, apelido, fone, data_nascimento, pontuacao)
    if jogador not in Hash:
        Hash.add(jogador)
    else:
        print("Atleta já cadastrado com este fone")


def mostrar_atleta_nome(lista):
    lista.sort(key=lambda a: a.nome)
    for atleta in lista:
        print(atleta)


def mostrar_atleta_pontos(lista):
    lista.sort(key=lambda a: a.pontuacao, reverse=True)
    for atleta in lista:
        print(atleta)


def procurar_nome(Hash, nome_procurado):
    encontrado = False
    for atleta in Hash:
        if atleta.nome == nome_procurado:
            print(atleta)
            encontrado = True
            break
    if not encontrado:
        print("Nome não encontrado")


def procurar_apelido(Hash, apelido_procurado):
    encontrado = False
    for atleta in Hash:
        if atleta.apelido == apelido_procurado:
            print(atleta)
            encontrado = True
            break
    if not encontrado:
        print("Apelido não encontrado")


def remover_nome(Hash, nome_procurado):
    nomes_a_remover = []
    for atleta in Hash:
        if atleta.nome == nome_procurado:
            nomes_a_remover.append(atleta)
            print("Atleta a ser removido:", atleta.nome)
    if nomes_a_remover:
        Hash.difference_update(nomes_a_remover)
        print("Atletas removidos com sucesso!")
    else:
        print("Nenhum atleta encontrado com o nome fornecido.")


def remover_apelido(Hash, apelido_procurado):
    apelidos_a_remover = []
    for atleta in Hash:
        if atleta.apelido == apelido_procurado:
            apelidos_a_remover.append(atleta)
            print("Atleta a ser removido:", atleta.apelido)
    if apelidos_a_remover:
        Hash.difference_update(apelidos_a_remover)
        print("Atletas removidos com sucesso!")
    else:
        print("Nenhum atleta encontrado com o apelido fornecido.")


if __name__ == "__main__":
    Hash = set()
    opcao = 0
    while opcao != 5:
        print("1 - Listar atletas")
        print("2 - Cadastrar atleta")
        print("3 - Procurar por atleta")
        print("4 - Remover atleta")
        opcao = int(input())
        
        if opcao == 1:  # Listar Atletas
            print("Quer mostrar por Nome? Digite 1 ou pontuacao? Digite 2")
            op2 = int(input())
            lista_atletas = list(Hash)
            if op2 == 1:
                mostrar_atleta_nome(lista_atletas)
            elif op2 == 2:
                mostrar_atleta_pontos(lista_atletas)
            else:
                print("Opcao invalida")

        elif opcao == 2:  # Criar atleta
            print("Digite o nome do Atleta")
            nome = input()
            print("Digite o apelido do Atleta")
            apelido = input()
            print("Digite o fone do Atleta")
            fone = input()
            print("Digite a data de nascimento do Atleta")
            data_nascimento = input()
            print("Digite a pontuacao do atleta")
            pontuacao = int(input())
            cadastrar_atleta(Hash, nome, apelido, fone, data_nascimento, pontuacao)

        elif opcao == 3:  # Procurar por nome ou apelido
            print("Quer mostrar por Nome? Digite 1 ou apelido? Digite 2")
            op3 = int(input())
            if op3 == 1:  # Nome
                print("Digite o nome que quer procurar")
                nome_procurado = input()
                procurar_nome(Hash, nome_procurado)
            elif op3 == 2:  # Apelido
                print("Digite o apelido que quer procurar")
                apelido_procurado = input()
                procurar_apelido(Hash, apelido_procurado)
            else:
                print("Opcao invalida")

        elif opcao == 4:  # Remover por nome ou apelido
            print("Quer mostrar por Nome? Digite 1 ou apelido? Digite 2")
            op4 = int(input())
            if op4 == 1:  # Nome
                print("Digite o nome que quer remover")
                nome_procurado = input()
                remover_nome(Hash, nome_procurado)
            elif op4 == 2:  # Apelido
                print("Digite o apelido que quer remover")
                apelido_procurado = input()
                remover_apelido(Hash, apelido_procurado)
            else:
                print("Opcao invalida")