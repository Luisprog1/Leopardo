package carneleopardo;

public class CarneLeopardoSistema {
	Contribuinte[] contribuintes;
	Tarifa [] tarifas;
	
	public CarneLeopardoSistema(){
		this.contribuintes = new Contribuinte[100];
		this.tarifas = new Tarifa[60];
	}
	
	public String cadastrarContribuinte(String cpf, String nome, String contato) throws IllegalArgumentException{
		Contribuinte contribuinte = new Contribuinte(cpf, nome, contato);
		for(int i = 0; i < contribuintes.length; i++) {
			if(this.contribuintes[i] != null){
				if(contribuintes[i].equals(contribuinte)) {
					throw new IllegalArgumentException("Contribuinte já cadastrado!");
				}
			contribuinte = new Contribuinte(cpf,nome,contato);
			contribuintes[i] = contribuinte;
			return contribuinte.toString();
			}
		}
		return "Contribuinte já cadastrado!";
	}

	public String[] listarContribuintes(Contribuinte [] contribuintes) {
		String[] listaContribuintes = new String[100];
		for(int i = 0; i < contribuintes.length; i++) {
			if(contribuintes[i] != null) {
				listaContribuintes[i] = contribuintes[i].toString();
			}
		}
		return listaContribuintes;
	}
	
	public int cadastrarTributo(int codigoTributo, String descricao, double valor, int ano) throws RuntimeException{
		if(codigoTributo > 60) {
			throw new IndexOutOfBoundsException("A faixa disponível para códigos tributários é de 1 a 60!");
		}
		if(tarifas[codigoTributo]!= null) {
			throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
		}
		Tarifa tarifa;
		if(tarifas[codigoTributo-1] != null) {
			tarifa = new Tarifa(codigoTributo, descricao, valor, ano);
			tarifas[codigoTributo-1] = tarifa;
		}
		return codigoTributo;
	}

	public String[] listarTributos(Tarifa[] tarifas) {
		String[] listaTarifas = new String[60];
		for(int i = 0; i < tarifas.length; i++) {
			if(tarifas[i] !=null) {
				listaTarifas[i] = tarifas[i].toString();
			}
		}
		return listaTarifas;
	}

	public double reajustarTributo(int codigoTributo, int ano, double percentual) {
		if(this.tarifas[codigoTributo] == null) {
			return 0;
		}
		return this.tarifas[codigoTributo].atualizaTarifa(percentual, ano);
	}

	public String atribuirTributoAoContribuinte(int codigoTributo, String cpfContribuinte){
		Tarifa tributo;
		for(int i = 0; i < this.tarifas.length; i++) {
			if(this.tarifas[i] != null && this.tarifas[i].getCodigo() == codigoTributo) {
				tributo = new Tarifa (this.tarifas[i].getCodigo(), this.tarifas[i].getDescricao(), this.tarifas[i].getValor(), this.tarifas[i].getAno());
				for(int j = 0; j < contribuintes.length; i++) {
					if(this.contribuintes[j] != null && cpfContribuinte.equals(this.contribuintes[j].getCpf())) {
						this.contribuintes[j].adicionarTarifa(tributo);
						return "| TRIBUTO ADICIONADO COM SUCESSO |";
					}
				}
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	
	public String pagarTributo(String cpfContribuinte, int codigoTributo){
		for(int i = 0; i < contribuintes.length; i++) {
			if(this.contribuintes[i] != null && cpfContribuinte.equals(this.contribuintes[i].getCpf())) {
				if(this.contribuintes[i].buscarTributo(codigoTributo)){
					this.contribuintes[i].setTributoPago(codigoTributo);
					return "| TRIBUTO PAGO COM SUCESSO |";
				}
			}
		}
		return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
	}
	
	public String emitirExtratoDeTributos(String cpfContribuinte){
		for(int i = 0; i < contribuintes.length; i++) {
			if(this.contribuintes[i] != null && cpfContribuinte.equals(this.contribuintes[i].getCpf())){
				return this.contribuintes[i].extrato();
			}
		}
		return "| EXTRATO VAZIO |";
	}

	public double totalPagoEmTributos(String cpfContribuinte, int ano) throws IllegalArgumentException{
		double total;
		for(int i = 0; i < contribuintes.length; i++) {
			if(this.contribuintes[i] != null && cpfContribuinte.equals(this.contribuintes[i].getCpf())){
				total = this.contribuintes[i].totalPagos(ano);
				return total;
			}
		}
		throw new IllegalArgumentException("Contribuinte não cadastrado!");
	}
}






























/*Contribuinte[] contributes;
	Tarifa [] tarifas;
	
	CarneLeopardoSistema()throws RuntimeException{
		contributes = new Contribuinte[100];
		tarifas = new Tarifa[60];
	}
	
	public String cadastrarContribuinte(String cpf, String nome, String contato) throws IllegalArgumentException{
		Contribuinte contribuinte;
		for(int i = 0; i < contributes.length; i++) {
			if(!this.contributes[i].equals(null)){
				if(contributes[i].getCpf() == cpf) {
					throw new IllegalArgumentException("Contribuinte já cadastrado!");
				}
			contribuinte = new Contribuinte(cpf,nome,contato);
			contributes[i] = contribuinte;
			return contribuinte.toString();
			}
		}
		return "Contribuinte já cadastrado!";
	}
	public void listarContribuintes(Contribuinte [] contributes) {
		for(int i = 0; i < contributes.length; i++) {
			if(!contributes[i].equals(null)) {
				System.out.println(contributes[i].toString());
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
				for(int j = 0; j < contributes.length; i++) {
					if(!contributes[j].equals(null) && contributes[j].getCpf() == cpfContribuinte && !tributo.equals(null)) {
						contributes[j].adicionarTarifa(tributo);
						return "| TRIBUTO ADICIONADO COM SUCESSO |";
					}
				}
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
	}*/
