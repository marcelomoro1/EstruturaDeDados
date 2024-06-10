package Exemplo;

import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		TreeSet<Aluno> arvore = new TreeSet<Aluno>();
		arvore.add(new Aluno(10,"Marcelo"));
		arvore.add(new Aluno(20,"Joao"));
		arvore.add(new Aluno(15,"Xiru"));
		
		for(Aluno a : arvore) {
			System.out.println(a);
		}
		
		
	}

}
