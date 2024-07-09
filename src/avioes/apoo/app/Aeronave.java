package avioes.apoo.app;

public class Aeronave {
	private String nRegistro;
	private String marcaEmodelo;
	private String NlugaresTuristica;
	private String NlugaresExecutiva;
	
	
	
	public Aeronave(String nRegistro, String marcaEmodelo, String nlugaresTuristica, String nlugaresExecutiva) {
		super();
		this.nRegistro = nRegistro;
		this.marcaEmodelo = marcaEmodelo;
		NlugaresTuristica = nlugaresTuristica;
		NlugaresExecutiva = nlugaresExecutiva;
	}
	
	
	public Aeronave() {
		
	}

	
	
	public String getnRegistro() {
		return nRegistro;
	}

	
	
	public void setnRegistro(String nRegistro) {
		this.nRegistro = nRegistro;
	}
	
	
	public String getMarcaEmodelo() {
		return marcaEmodelo;
	}
	
	
	public void setMarcaEmodelo(String marcaEmodelo) {
		this.marcaEmodelo = marcaEmodelo;
	}
	
	public String getNlugaresTuristica() {
		return NlugaresTuristica;
	}
	
	public void setNlugaresTuristica(String nlugaresTuristica) {
		NlugaresTuristica = nlugaresTuristica;
	}
	
	public String getNlugaresExecutiva() {
		return NlugaresExecutiva;
	}
	
	public void setNlugaresExecutiva(String nlugaresExecutiva) {
		NlugaresExecutiva = nlugaresExecutiva;
	}

	@Override
	public String toString() {
		return "Aeronave [\n  Numero de registro: " + nRegistro + "\n  Marca/modelo: " + marcaEmodelo + "\n  Numero de lugares turustica: "
				+ NlugaresTuristica + "\n  Numero de lugares executiva: " + NlugaresExecutiva + "\n]" + "\n----------------------------------";
	}
	
	
}
