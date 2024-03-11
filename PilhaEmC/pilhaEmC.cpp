#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct nodo 
{
    int dado;
    struct nodo *prox;
} Pilha;

Pilha *inserir(int valor, Pilha *topo) 
{
    //alocar memoria
    Pilha *novo = (Pilha *)malloc(sizeof(Pilha));

    //depositar valores
    novo->dado = valor;

    //empilhar com encadeamento
    novo->prox = topo;

    //retornar o novo topo
    return novo;
}

void exibir(Pilha *topo) 
{
    Pilha *p;
    for (p = topo; p; p = p->prox) 
    {
        cout << p->dado << endl;
    }
}

int topo(Pilha *topo) 
{
    if (!topo) return -27;

    return topo->dado;
}

bool localizado(int valor, Pilha *topo) 
{
    Pilha *p;
    for (p = topo; p ; p = p->prox) 
    {
        if (valor == p->dado)
        {
            return true;
        }
    }
    return false;
}

Pilha *remover(Pilha* topo) 
{
    if (!topo) return topo;

    Pilha *lixo;
    //reservar o topo que sera excluido
    lixo = topo;
    //avancar para o novo topo
    topo = topo->prox;
    //apagar o elemento reservado
    free(lixo);
    //retornar o novo topo
    return topo;
}

Pilha *limpar(Pilha* topo){
    Pilha *lixo;
    if (!topo) return topo;
    for (lixo = topo, topo = topo->prox; topo!=NULL; lixo = topo, topo = topo->prox) //lixo armazena o topo, topo vai pro proximo enquando for diferente de nulo e vai limpando
    {
        free(lixo);       
    }
    free(lixo); 
    return NULL;
}

int main() 
{
    Pilha *pilha = NULL;

    pilha = inserir(10, pilha);
    pilha = inserir(15, pilha);
    pilha = inserir(5, pilha);

    exibir(pilha);
    cout << topo(pilha) << endl;

    cout << localizado(6,pilha) << endl;

    pilha = remover(pilha);
    cout << "Pilha alterada" << endl;

    exibir(pilha); //Pilha sem o topo

    pilha = limpar(pilha);

    cout<< "Pilha limpa"<<endl;
    exibir(pilha); //Pilha nula
    return 1;

}