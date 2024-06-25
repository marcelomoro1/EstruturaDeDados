import java.util.ArrayList;


class Grafo {
    private int[][] matrizAdjacencia;
    private ArrayList<String> vertices;
    private int qtdVertices;
    public Grafo(ArrayList<String> vertices) {
        this.vertices = new ArrayList<>(); //lista das cidades
        this.vertices.addAll(vertices); //adiciona todas cidades, faz uma copia 
        this.qtdVertices = vertices.size();//qnd chama qtd vertices vai mostrar size
        this.matrizAdjacencia = new int[this.qtdVertices][this.qtdVertices]; //matriz quadrada das cidades
        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.matrizAdjacencia[i][j] = 0; //inicia em 0
            }
        }
    }
    public void inserirArestaSimetrica(String origem, String destino) {
        int indiceOrigem = this.vertices.indexOf(origem);
        int indiceDestino = this.vertices.indexOf(destino);
        if (indiceOrigem == -1 || indiceDestino == -1 || origem.equalsIgnoreCase(destino)) {
            return; //Não tem na lista
        }
        if (this.matrizAdjacencia[indiceOrigem][indiceDestino] == 0) {
            this.matrizAdjacencia[indiceOrigem][indiceDestino] = 1;
        } 
        if (this.matrizAdjacencia[indiceDestino][indiceOrigem] == 0) {
            this.matrizAdjacencia[indiceDestino][indiceOrigem] = 1;
        }
    }

    public void show() { //Exibe a matriz
        System.out.print("\t\t");
        for (String i : vertices) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(this.vertices.get(i) + "\t");
            for (int j = 0; j < this.qtdVertices; j++) {
                System.out.print(this.matrizAdjacencia[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int mostrarGrau(String cidade) { 
        int indice = this.vertices.indexOf(cidade); //Atribui a variavel o indice da cidade na lista
        if (indice == -1) return -1; //Não existe
        int qtd = 0;
        for (int i = 0; i < this.qtdVertices; i++) { // Percorre a lista de vertices
            if (this.matrizAdjacencia[indice][i] != 0) { //Se for diferente de zero tem conexao
                qtd++; 
            }
            if (this.matrizAdjacencia[i][indice] != 0) {
                qtd++; 
            }
        }
        return qtd; 
    }

}