package Matriz;

import java.util.HashSet;
import java.util.Objects;

public class Celula {
	int linha;
	int coluna;
	int valor;
	static int qtdLinhas;
	static int qtdColunas;
	
	public Celula(int linha, int coluna, int valor) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Celula [linha=" + linha + ", coluna=" + coluna + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(coluna, linha);
	}

	public static void transformaMatrizHash(int matriz[][], HashSet<Celula> tabelaHash) {
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0;j<matriz[i].length;j++) {
				if (matriz[i][j]!=0) {
					tabelaHash.add(new Celula(i,j,matriz[i][j]));
				}
			}
		}
		Celula.qtdLinhas = matriz.length;
		Celula.qtdColunas = matriz[0].length;
	}
	
	public static void exibeMatrizHash (HashSet<Celula> tabelaHash) {
		System.out.println("Matriz ["+Celula.qtdLinhas+"]"+"["+Celula.qtdColunas+"]");
		
		for(Celula i : tabelaHash) {
			System.out.println(i);
		}
	}

	public static void transformaHashMatriz(HashSet<Celula> tabelaHash, int[][] outraMatriz) {
		for(int i=0;i<outraMatriz.length;i++) {
			for(int j = 0;j<outraMatriz[i].length;j++) {
				outraMatriz[i][j]=0;
			}
		}
		for(Celula i : tabelaHash) {
			outraMatriz[i.linha][i.coluna] = i.valor;
		}
		
	}
	
	
}
