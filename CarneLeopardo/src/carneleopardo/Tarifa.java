package carneleopardo;

import java.util.ArrayList;

public class Tarifa {
	int codigo;
	String descricao;
	double valor;
	int ano;
	boolean status;
	ArrayList<Contribuinte> contribuintes;
    public Tarifa clone;
	
	public Tarifa(int codigo, String descricao, double valor, int ano) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.ano = ano;
		this.contribuintes = new ArrayList<Contribuinte>();
	}
	
	public void pagar() {
		this.status = true;
	}

	public int getCodigo(){
		return codigo;
	}

	public String getDescricao(){
		return descricao;
	}

	public double getValor(){
		return valor;
	}

	public int getAno(){
		return ano;
	}

	public void adicionarContribuinte(Contribuinte contribuinte) {
		contribuintes.add(contribuinte);
	}
	public double atualizaTarifa(double porcentagem, int ano) {
		this.valor = valor + valor* porcentagem;
		this.ano = ano;
		return valor;
	}
	@Override
	public String toString() {
		return "| Tributo: " + codigo + " - " + descricao + " - Valor: " + String.format("%.2f", valor) + " - Ano Base: " + ano + " |";
	}
	
}
