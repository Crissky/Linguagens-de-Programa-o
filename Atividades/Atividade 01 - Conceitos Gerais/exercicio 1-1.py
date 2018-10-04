carro = {"tipo":"carro", "rodas": "4"}
moto = {"tipo":"moto", "rodas": "2"}

if(__name__ == "__main__"):
    while 1:
        escolha = str(input("deseja escolher um carro ou moto? ")).lower()
        if(escolha == "carro"):
            print("O " + carro["tipo"] + " possui " + carro["rodas"] + " rodas.")
        elif(escolha == "moto"):
            print("A " + moto["tipo"] + " possui " + moto["rodas"] + " rodas.")
        else:
            print("Opção inválida")
        input("ENTER para continuar. \n")
