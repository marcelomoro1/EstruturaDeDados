package AtletaJava;

import java.util.Objects;

public class Atleta {
	String nome;
	String fone;
	String apelido;
	String dataNasc;
	int pontuacaoAcumulada;
	
	public Atleta(String nome, String fone, String apelido, String data, int pontos){
		this.nome = nome;
		this.fone = fone;
		this.apelido = apelido;
		this.dataNasc = data;
		this.pontuacaoAcumulada = pontos;
	}
	
	public Atleta(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getPontuacaoAcumulada() {
		return pontuacaoAcumulada;
	}

	public void setPontuacaoAcumulada(int pontuacaoAcumulada) {
		this.pontuacaoAcumulada = pontuacaoAcumulada;
	}

	@Override
	public String toString() {
		return "Atleta [nome=" + nome + ", fone=" + fone + ", apelido=" + apelido + ", dataNasc=" + dataNasc
				+ ", pontuacaoAcumulada=" + pontuacaoAcumulada + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(fone, other.fone);
	}

	
	
	
}
