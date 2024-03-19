#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;


typedef struct no {
    int dado;
    struct no *prox;
} Lista;

void emComum(Lista *lista1, Lista *lista2){
        Lista *p1;
        Lista *p2;
        cout<<"Numeros iguais"<<endl;
        for(p1=lista1;p1; p1=p1->prox){
            for(p2=lista2;p2; p2=p2->prox){
                if(p1->dado==p2->dado){
                    cout<< p1->dado<<endl;
                }
            }
    }
}

void diferentes (Lista *lista1, Lista *lista2){
        Lista *p1;
        Lista *p2;
        bool encontrou = false;
        cout <<"Dados diferentes: "<<endl;
        for(p1=lista1; p1; p1=p1->prox){
            for(p2=lista2; p2; p2=p2->prox){
                if(p1->dado!=p2->dado){
                    encontrou = true;
                    break;
                }
            }
        if (!encontrou){
            
        }    
    }
}

void exibir(Lista *lista){
    Lista *p;
    for (p = lista; p; p = p->prox) {
        cout << p->dado << endl;
    }
}

int contar(Lista *lista){
    Lista *p;
    int qtd = 0;
    for (p = lista; p; p = p->prox) {
        qtd++;
    }
    return qtd;
}

bool localizar(int valor, Lista *lista) {
    Lista *p;
    
    for (p = lista; p; p = p->prox) {
        if (valor == p->dado)
            return true;
    }
    return false;
}

Lista *inserir(int valor, Lista *lista) {
    //alocar memoria
    Lista *novo;
    novo = (Lista*)malloc(sizeof(Lista));

    //depositar valores
    novo->dado = valor;
    novo->prox = NULL;

    //engatar novo na sua posicao
    Lista *p, *pR;
    for (pR = NULL, p = lista; p ; pR = p, p = p->prox) {
        if (valor == p->dado) {
            free(novo);
            return lista;
        }
        if (valor < p->dado) {
            //achei a posicao
            break;
        }
    }
    //inserir na primeira posicao
    if (p == lista) {
        novo->prox = p;
        return novo;
    }
    //inserir na ultima posicao
    if (!p) {
        pR->prox = novo;
        return lista;
    }
    //inserir em alguma posicao do meio
    pR->prox = novo;
    novo->prox = p;
    return lista;
}



int main() {

    Lista *lista1 = NULL;
    int qtd = 10;
    srand(time(NULL));

    Lista *lista2 = NULL;
    int qtd2 = 10;
    srand(time(NULL));

    Lista *p1;
    Lista *p2;



    for (; qtd > 0; qtd--) { //Lista 1
        lista1 = inserir(rand() % 20, lista1);
    }
    cout << "Tamanho da lista 1 " << contar(lista1) << endl;
    exibir(lista1);


    for (; qtd2 > 0; qtd2--) { //Lista 2
        lista2 = inserir(rand() % 20, lista2);
    }
    cout << "Tamanho da lista 2 " << contar(lista2) << endl;
    exibir(lista2);

    emComum(lista1,lista2);
    diferentes(lista1,lista2);

    return 1;
}