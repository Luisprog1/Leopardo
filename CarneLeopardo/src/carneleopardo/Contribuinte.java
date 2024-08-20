package carneleopardo;

import java.util.ArrayList;
import java.util.Objects;

public class Contribuinte {
	String cpf;
	String nome;
	String contato;
	ArrayList<Tarifa> tarifas;
	
	public Contribuinte(String cpf, String nome, String contato){
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.tarifas = new ArrayList<Tarifa>();
	}

	
	public String getCpf() {
		return cpf;
	}
	
	public void adicionarTarifa(Tarifa tarifa) {
		tarifas.add(tarifa);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contribuinte other = (Contribuinte) obj;
		return Objects.equals(cpf, other.cpf);
	}


	@Override
	public String toString() {
		return "Contribuinte: " + nome + " - CPF: " + cpf + " - Contato: " + contato;
	}
	
}
