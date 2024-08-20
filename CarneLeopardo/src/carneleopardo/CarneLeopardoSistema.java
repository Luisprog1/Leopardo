package carneleopardo;

public class CarneLeopardoSistema {
	Contribuinte[] contribuintes;
	Tarifa [] tarifas;
	
	CarneLeopardoSistema()throws RuntimeException{
		contribuintes = new Contribuinte[100];
		tarifas = new Tarifa[60];
	}
	
	public String cadastrarContribuinte(String cpf, String nome, String contato) throws IllegalArgumentException{
		Contribuinte contribuinte;
		for(int i = 0; i < contribuintes.length; i++) {
			if(!this.contribuintes[i].equals(null)){
				if(contribuintes[i].getCpf() == cpf) {
					throw new IllegalArgumentException("Contribuinte já cadastrado!");
				}
			contribuinte = new Contribuinte(cpf,nome,contato);
			contribuintes[i] = contribuinte;
			return contribuinte.toString();
			}
		}
		return "Contribuinte já cadastrado!";
	}
	public void listarContribuintes(Contribuinte [] contribuintes) {
		for(int i = 0; i < contribuintes.length; i++) {
			if(!contribuintes[i].equals(null)) {
				System.out.println(contribuintes[i].toString());
			}
		}
	}
	
	public int cadastrarTributo(int codigoTributo, String descricao, double valor, int ano) throws RuntimeException{
		if(codigoTributo > 60) {
			throw new IndexOutOfBoundsException("A faixa disponível para códigos tributários é de 1 a 60!");
		}
		if(tarifas[codigoTributo]!= null) {
			throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
		}
		Tarifa tarifa;
		if(!tarifas[codigoTributo-1].equals(null)) {
			tarifa = new Tarifa(codigoTributo, descricao, valor, ano);
			tarifas[codigoTributo-1] = tarifa;
		}
		return codigoTributo;
	}
	public void listarTributos(Tarifa[] tarifas) { 
		for(int i = 0; i < tarifas.length; i++) {
			if(!tarifas[i].equals(null)) {
				System.out.println(tarifas[i].toString());
			}
		}
	}

	public String atribuirTributoAoContribuinte(int codigoTributo, String cpfContribuinte){
		Tarifa tributo;
		for(int i = 0; i < tarifas.length; i++) {
			if(!tarifas[i].equals(null) && tarifas[i].getCodigo() == codigoTributo) {
				tributo = new Tarifa (tarifas[i].getCodigo(), tarifas[i].getDescricao(), tarifas[i].getValor(), tarifas[i].getAno());
			}
			return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
		}
		for(int i = 0; i < contribuintes.length; i++) {
			if(!contribuintes[i].equals(null) && contribuintes[i].getCpf() == cpfContribuinte && !tributo.equals(null)) {
				contribuintes[i].adicionarTarifa(tributo);
				return "| TRIBUTO ADICIONADO COM SUCESSO |";
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	public String pagarTributo(String cpfContribuinte, int codigoTributo){

		return "";
	}

	public double reajustarTributo(int codigoTributo, int ano, double percentual) {
		if(tarifas[codigoTributo] == null) {
			return 0;
		}
		return tarifas[codigoTributo].atualizaTarifa(percentual, ano);
	}
}
