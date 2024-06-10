package Exemplo;

import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
	public int matricula;
	public String nome;
	
	
	public Aluno(int matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	//Compare para mostrar pra arvore que ela deve inserir os valores na arvore pela matricula
	@Override
	public int compareTo(Aluno o) {
		if (this.matricula < o.matricula) {
			return -1; //esquerda
		}
		if (this.matricula > o.matricula) {
			return 1; //direita
		}
		return 0;
	}

	//toString para mostrar a arvore com o sysout
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}

	//Equals para comparar matricula
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return matricula == other.matricula;
	}

	
	
	
	
}
