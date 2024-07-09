package avioes.apoo.app;

public class Aeroporto {
	private String sigla;
	private String pais;
	private String cidadeProx;
	
	
	public Aeroporto(String sigla, String pais, String cidadeProx) {
		super();
		this.sigla = sigla;
		this.pais = pais;
		this.cidadeProx = cidadeProx;
	}
	public Aeroporto() {
		
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidadeProx() {
		return cidadeProx;
	}
	public void setCidadeProx(String cidadeProx) {
		this.cidadeProx = cidadeProx;
	}
	@Override
	public String toString() {
		return "Aeroporto [\n  Sigla: " + sigla + "\n  Pais: " + pais + "\n  Cidade mais proxima: " + cidadeProx + "\n]" 
	+ "\n-------------------------------";
	}
	
	
	
	
	
	
}
