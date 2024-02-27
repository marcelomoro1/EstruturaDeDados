#include <iostream>
#include <fstream>
#include <string>
using namespace std;

typedef struct nodo {
    int valor;
    struct nodo *prox;
} Pilha;

Pilha *inserir(int valor, Pilha *topo) {
    //alocar memoria
    Pilha *novo = (Pilha *)malloc(sizeof(Pilha));
    
    //depositar valores dos parametros na estrutura criada
    novo->valor = valor;
    
    //engatar
    novo->prox = topo;

    //retornar
    return novo;
}

void imprimir(Pilha *topo) {
    if (!topo) return;
    
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        cout << i->valor << endl;
    }
}

int contarElementos(Pilha *topo) {
    if (!topo) return 0;
    int quantidade = 0;
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        quantidade++;
    }
    return quantidade;
}

bool estaContido(int valor, Pilha *topo) {
    if (!topo) return 0;
    
    for (Pilha *i = topo; i != NULL; i = i->prox) {
        if (valor == i->valor){
            return true;
        }
    }
    return false;
}

Pilha *remover(Pilha *topo) {
    //verificar se existe
    if (!topo) return topo;

    //isolar o topo
    Pilha *lixo = topo;

    //atualizar o novo topo
    topo = topo->prox;

    //liberar memoria
    free(lixo);

    //retornar o novo topo
    return topo;
}

int main() {
    Pilha *pilha = NULL;

    int valor;
    
    string nomeArquivo = "2.dat"; //Salva o nome do arquivo com os numeros
    ifstream procurador; //Começa a abrir o arquivo pra leitura
    procurador.open(nomeArquivo); //Através do procurador ele abre o arquivo com os numeros
    if (!procurador) { //Caso não exista o arquivo ele não abre
        cerr << "Erro ao abrir o arquivo " << endl;
        return 1;
    }

    while(!procurador.eof()){ // executa enquanto não chegar no final do arquivo EOF = End of File
        string linha;
        getline(procurador,linha); //Pega a linha atual do arquivo dos numeros
        pilha = inserir(stoi(linha),pilha); //Insere a linha

    }
    procurador.close(); //Fecha o arquivo

    imprimir(pilha);
    cout << "Pilha com um total de " << contarElementos(pilha) << " elementos" << endl;

    return 1;
}