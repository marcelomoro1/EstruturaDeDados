package Atleta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Principal {
	
	public static void cadastrarAtleta(HashSet<Atleta> Hash, Atleta jogador,String nome, String fone, String apelido, String dataNascimento, int pontuacao) {
		jogador = new Atleta(nome,fone,apelido,dataNascimento, pontuacao);			
		if (!Hash.add(jogador) ) {
			System.out.println("Atleta ja cadastrado com este fone");
		}
	}
	
	public static void mostrarAtletaNome(ArrayList<Atleta> lista){
		lista.sort((a1,a2)->((String)a1.getNome()).compareTo(a2.getNome()));
		for(Atleta i: lista) {
			System.out.println(i);
		}
	}
	
	public static void mostrarAtletaPontos(ArrayList<Atleta> lista){
		lista.sort((a2,a1)->((String)a1.getNome()).compareTo(a2.getNome()));
		for(int i = lista.size() - 1; i >= 0; i--) {
			Atleta jogador = lista.get(i);
		    System.out.println(jogador);
		}
	}
	
	public static void procurarNome(HashSet<Atleta> Hash, String nomeProcurado) {
		for(Atleta i: Hash) {
			if(i.getNome().equals(nomeProcurado)) {
				System.out.println(i);
			}
			else {
				System.out.println("Nome nao encontrado");
			}
		}
	}
	
	public static void procurarApelido(HashSet<Atleta> Hash, String apelidoProcurado) {
		for(Atleta i: Hash) {
			if(i.getApelido().equals(apelidoProcurado)) {
				System.out.println(i);
			}
			else {
				System.out.println("Apelido nao encontrado");
			}
		}
	}
	
	public static void removerNome(HashSet<Atleta> Hash, String nomeProcurado) {
		ArrayList<Atleta> nomesARemover = new ArrayList<>();
        for (Atleta atleta : Hash) {
            if (atleta.getNome().equals(nomeProcurado)) {
                nomesARemover.add(atleta);
                System.out.println("Atleta a ser removido: " + atleta.getNome());
            }
        }
        if (!nomesARemover.isEmpty()) {
            Hash.removeAll(nomesARemover);
            System.out.println("Atletas removidos com sucesso!");
        } else {
            System.out.println("Nenhum atleta encontrado com o nome fornecido.");
        }
	}
	
	public static void removerApelido(HashSet<Atleta> Hash, String apelidoProcurado) {
        ArrayList<Atleta> apelidosARemover = new ArrayList<>();
        for (Atleta atleta : Hash) {
            if (atleta.getApelido().equals(apelidoProcurado)) {
                apelidosARemover.add(atleta);
                System.out.println("Atleta a ser removido: " + atleta.getApelido());
            }
        }
        if (!apelidosARemover.isEmpty()) {
            Hash.removeAll(apelidosARemover);
            System.out.println("Atletas removidos com sucesso!");
        } else {
            System.out.println("Nenhum atleta encontrado com o apelido fornecido.");
        }
	}
	


	public static void main(String[] args) {
		int opcao;
		Scanner teclado = new Scanner(System.in);
		HashSet<Atleta> Hash = new HashSet<Atleta>();
		Atleta jogador = new Atleta();
		String nome, fone, apelido, dataNascimento;
		String nomeProcurado, apelidoProcurado;
		int pontuacao;
		ArrayList<Atleta> listaAtletas = new ArrayList<Atleta>();
		do {
			
			System.out.println("1 - Listar atletas");
			System.out.println("2 - Cadastrar atleta");
			System.out.println("3 - Procurar por atleta");
			System.out.println("4 - Remover atleta");	
			opcao = teclado.nextInt();
			teclado.nextLine();
	
			switch(opcao) {
			
			case 1: //Listar Atletas
				System.out.println("Quer mostrar por Nome? Digite 1 ou pontuacao? Digite 2");
				int op2 = teclado.nextInt();
				teclado.nextLine();
				
				listaAtletas.clear();
				if (listaAtletas.isEmpty()) {
					listaAtletas.addAll(Hash);				
				}		
				if(op2==1) {
				    mostrarAtletaNome(listaAtletas);
				}
				else if(op2==2) {
					mostrarAtletaPontos(listaAtletas);
				}
				else {
					System.out.println("Opcao invalida");
				}					
				break;
				
			case 2: //Criar atleta
				System.out.println("Digite o nome do Atleta");
				nome = teclado.nextLine();
				System.out.println("Digite o fone do Atleta");
				fone = teclado.nextLine();
				System.out.println("Digite o apelido do Atleta");
				apelido = teclado.nextLine();
				System.out.println("Digite a data de nascimento do Atleta");
				dataNascimento = teclado.nextLine();
				System.out.println("Digite a pontuacao do atleta");
				pontuacao = teclado.nextInt();
				teclado.nextLine();
				
				cadastrarAtleta(Hash, jogador, nome, fone, apelido, dataNascimento, pontuacao);

				break;
				
			case 3: //Procurar por nome ou apelido
				System.out.println("Quer mostrar por Nome? Digite 1 ou apelido? Digite 2");
				int op3 = teclado.nextInt();
				teclado.nextLine();
				
				if(op3==1) { //Nome
					System.out.println("Digite o nome que quer procurar");
					nomeProcurado = teclado.nextLine();
					
					procurarNome(Hash, nomeProcurado);

			    }
				else if(op3==2) { //Apelido
					System.out.println("Digite o apelido que quer procurar");
					apelidoProcurado = teclado.nextLine();
					
					procurarApelido(Hash, apelidoProcurado);
					
				}
				else {
					System.out.println("Opcao invalida");
				}
				break;

			case 4: //Remover por nome ou apelido
				System.out.println("Quer mostrar por Nome? Digite 1 ou apelido? Digite 2");
				int op4 = teclado.nextInt();
				teclado.nextLine();
				if(op4==1) { //Nome
					System.out.println("Digite o nome que quer remover");
		            nomeProcurado = teclado.nextLine();

		            removerNome(Hash, nomeProcurado);

			    }
				else if(op4==2) { //Apelido
					System.out.println("Digite o apelido que quer remover");
		            apelidoProcurado = teclado.nextLine();
		            
		            removerApelido(Hash, apelidoProcurado);
				break;
				}
			default:
				System.out.println("Opcao invalida");
				break;
			}
			
		}while(opcao!=5);

	}

}
