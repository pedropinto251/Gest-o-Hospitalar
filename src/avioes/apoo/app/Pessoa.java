package avioes.apoo.app;

public class Pessoa {
	
	private String id;
	private String nome;
	private String nacionalidade;
	private String morada;
	private String telefone;
	private String dataDeNascimento;
	
	
	public Pessoa(String id, String nome, String nacionalidade, String morada, String telefone, String dataDeNascimento) {
			
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.morada = morada;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		
	}
	
	public Pessoa(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	
}
	