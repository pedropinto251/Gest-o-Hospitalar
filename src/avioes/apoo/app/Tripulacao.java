package avioes.apoo.app;

public class Tripulacao extends Pessoa {
	
	private String nLicenca;
	private String dataDeValidade;
	private String anotacoes;
	private String categoria;
	private String nVoo;
	
	public Tripulacao(String id, String nVoo, String nome, String nacionalidade, String morada, String telefone, String dataDeNascimento,
			String nLicenca, String dataDeValidade, String anotacoes, String categoria) {
		
		super(id, nome, nacionalidade, morada, telefone, dataDeNascimento);
		
		this.nLicenca = nLicenca;
		this.dataDeValidade = dataDeValidade;
		this.anotacoes = anotacoes;
		this.categoria = categoria;
		this.nVoo = nVoo;
	}

	public Tripulacao() {
		
	}
	
	public String getnVoo() {
		return this.nVoo;
	}

	public void setnVoo(String nVoo) {
		this.nVoo = nVoo;
	}

	public String getnLicenca() {
		return nLicenca;
	}

	public void setnLicenca(String nLicenca) {
		this.nLicenca = nLicenca;
	}

	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(String dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Tripulante [\n  Id: " + getId() + "\n  Nome: " + getNome() + "\n  Nacionalidade: " + getNacionalidade() + 
				"\n  Morada: " + getMorada() + "\n  Telefone: " + getTelefone() + "\n  Data de nascimento: " + 
				getDataDeNascimento() + "\n  Numero da licenca: " + nLicenca + "\n  Data de validade: " + dataDeValidade + "\n  Anotacoes: " + anotacoes
				+ "\n  Categoria: " + categoria + "" + "\n]\n" + 
				"------------------------------------------------------";
				
	}
	
	

}
