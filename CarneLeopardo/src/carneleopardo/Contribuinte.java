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

	public boolean buscarTributo(int codigoTributo){
		for(Tarifa tarifa: this.tarifas){
			if(codigoTributo == tarifa.getCodigo()){
				return true;
			}
		}
		return false;
	}
	
	public boolean setTributoPago(int codigoTributo){
		for(Tarifa tarifa: this.tarifas){
			if(codigoTributo == tarifa.getCodigo()){
				tarifa.pagar();
				return true;
			}
		}
		return false;
	}

	public String extrato(){
		String todosExtratos = "";
		for(Tarifa tarifa: tarifas){
			if(tarifa.getStatus()){
				todosExtratos += ("| SIM | " + tarifa.toString());
			}
			todosExtratos += ("| NÃO |" + tarifa.toString());
		}
		return todosExtratos;
	}

	public double totalPagos(int ano){
		double total = 0;
		for(Tarifa tarifa: this.tarifas){
			if(tarifa.getAno() == ano){
				total += tarifa.getValor();
			}
		}
		return total;
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
