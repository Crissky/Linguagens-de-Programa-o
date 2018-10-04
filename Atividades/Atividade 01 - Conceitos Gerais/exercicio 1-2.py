class Veiculo:
    rodas = "0"
    tipo = "não definido"

    def getRodas(self):
        return self.rodas

    def getTipo(self):
        return self.tipo

    def __str__(self):
        return self.getTipo() + " possui " + self.getRodas() + " rodas."

class Carro(Veiculo):
    rodas = "4"
    tipo = "Carro"
    
class Moto(Veiculo):
    rodas = "2"
    tipo = "Moto"

if(__name__ == "__main__"):
    while 1:
        escolha = str(input("deseja escolher um carro ou moto? ")).lower()
        if(escolha == "carro"):
            print(Carro())
        elif(escolha == "moto"):
            print(Moto())
        else:
            print("Opção inválida")
        input("ENTER para continuar. \n")
