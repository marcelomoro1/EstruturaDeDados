package Matriz;

import java.util.HashSet;

public class Main {
	
	public class ExemploMatrizEspecialTratada{
		
		public static void criar(int matriz[][], int linhas, int colunas) {

			for (int i = 0; i<linhas;i++) {
				for(int j = 0; j<colunas;j++) {
					matriz[i][j]=0;
				}
			}
		}
		

		public static void exibir(int matriz[][]) {
			for (int i = 0; i<matriz.length;i++) {
				for(int j = 0; j<matriz[i].length;j++) {
					System.out.print(matriz[i][j]+"\t");
				}
				System.out.println();
			}
		}
		
		
	}

	public static void main(String[] args) {
		int tamlinha =5;
		int tamcoluna=5;
		int matrizEspecial[][] = new int[tamlinha][tamcoluna];
		ExemploMatrizEspecialTratada.criar(matrizEspecial, 5, 5);
		
		matrizEspecial[0][0]=5;
		matrizEspecial[2][3]=5;
		matrizEspecial[4][2]=5;
		
		ExemploMatrizEspecialTratada.exibir(matrizEspecial);
		
		HashSet<Celula> tabelaHash = new HashSet<Celula>();
		
		//Gera hash a partir de matriz normal
		System.out.println("Gerando hash set a partir da matriz");
		Celula.transformaMatrizHash(matrizEspecial, tabelaHash);
		Celula.exibeMatrizHash(tabelaHash);
		
		//Gera matriz normal a partir de hash
		System.out.println("Gerando matriz a partir do hash set");
		int outraMatriz[][] = new int[Celula.qtdLinhas][Celula.qtdColunas];
		Celula.transformaHashMatriz(tabelaHash, outraMatriz);
		ExemploMatrizEspecialTratada.exibir(outraMatriz);
	}

}
